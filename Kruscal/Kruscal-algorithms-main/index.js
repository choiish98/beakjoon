const nodePad = document.querySelector(".nodePad");
const nodePad2 = document.querySelector(".pad2");
const canvas = nodePad.querySelector(".canvas1");
const canvas2 = nodePad2.querySelector(".canvas2");
const button = document.querySelector(".inputBtn");
const form = document.querySelector(".form");
const mResult = document.querySelector(".mResult");
const fResult = document.querySelector(".fResult");
const pmResult = document.querySelector(".pmResult");
const pfResult = document.querySelector(".pfResult");
const clearBtn = document.querySelector(".clear");

class Node {
    constructor(start, stop, weight) {
        this.start = start;
        this.stop = stop;
        this.weight = weight;
    }
}

class PriorityQueue {
    constructor() {
      this.store = [];
    }
    
    enqueue(item) {
      this.store.push(item);
    }
    
    dequeue() {
      let entry = 0;
      this.store.forEach((item, index) => {
        if (this.store[entry].weight > this.store[index].weight) {
          entry = index;
        }
      });
      return this.store.splice(entry, 1);
    }
}

var index = 1;                      // number of node in canvas
var lineNumber = 0;                 // number of node in script
var context2;                       // canvas on nodePad2
var randomInt;                      // prim start node
 
const x = new Array();              // mouse x position
const y = new Array();              // mouse y position
const node = new Array();           // node class
const parent = new Array();         // node parent array
const primArray = new Array();      // prim's Array
const nodeList = new Array();       // node List using in prim
nodeList.push([])


function makeNode(event){
    event.preventDefault();

    // 마우스 좌표 받아오기
    x[index] = event.clientX;
    y[index] = event.clientY;

    // span 생성
    var newDIV = document.createElement("span");

    // span 속성 추가
    newDIV.setAttribute("class", "node");
    newDIV.innerHTML = `${index}`;
    newDIV.style.backgroundColor = "Skyblue";
    newDIV.style.position = "absolute";
    newDIV.style.left = `${x[index]}px`;
    newDIV.style.top = `${y[index]}px`;

    //콤보 박스
    document.getElementById("start").appendChild(new Option(index, index));
    document.getElementById("stop").appendChild(new Option(index, index));

    // span 생성
    nodePad.appendChild(newDIV);
    index++;

    // 인접리스트 원소 하나씩 생성
    nodeList.push([]);
}

function makeLine(){

    // context 생성
    var context = canvas.getContext("2d");

    // context 속성 추가
    context.beginPath();
    context.moveTo(x[document.getElementById("start").value], y[document.getElementById("start").value]);
    context.lineTo(x[document.getElementById("stop").value], y[document.getElementById("stop").value]);
    context.strokeStyle = "black";
    context.lineWidth = 0.5;

    // context 그리기
    if(0){  // 간선 사이에 노드가 있을 경우
        for(var i = 0; i < index; i++){
            if(nodePad.children[i].getBoundingClientRect() == context.getBoundingClientRect()){
                var warn = document.createElement("div");
                warn.innerHTML = "간선과 노드가 맞닿습니다.";
                nodePad.appendChild(warn);
            }
        }
    } else {
    context.stroke();
    context.strokeText(document.getElementById("weight").value,
    (x[document.getElementById("start").value] + x[document.getElementById("stop").value]) / 2,
    (y[document.getElementById("start").value] + y[document.getElementById("stop").value]) / 2);
    }

    node[lineNumber] = new Node(document.getElementById("start").value, 
                    document.getElementById("stop").value,
                    document.getElementById("weight").value);
    lineNumber++;

    // 인접 리스트 원소 하나씩 추가
    var sss = [document.getElementById("stop").value,
                document.getElementById("weight").value];
    var ss = [document.getElementById("start").value,
                document.getElementById("weight").value];
    nodeList[document.getElementById("start").value].push(sss);
    nodeList[document.getElementById("stop").value].push(ss);
}

function kruskal(event) {
    for(var j = 0; j < lineNumber; j++){
        parent[j] = j;
    }

    // array sort by weight
    node.sort(function(a, b) {
        var keyA = a.weight,
            keyB = b.weight;
        
        if (keyA < keyB) return -1;
        if (keyA > keyB) return 1;
        return 0;
    })

    var kruskalRange = 0;
    if(event.target == mResult) kruskalRange = lineNumber / 4;
    else if(event.target == fResult) kruskalRange = lineNumber;
    console.log(kruskalRange);

    for(var i = 0; i < kruskalRange; i++) {
        // no cycle
        if(!findParent(parent, node[i].start, node[i].stop)) {
            // union parent
            unionParent(parent, node[i].start, node[i].stop);

            // y += 630
            // print node in canvas1
            // span 생성
            var newDIV = document.createElement("span");
            var newDIV2 = document.createElement("span");

            // span 속성 추가
            newDIV.setAttribute("class", "node");
            newDIV.innerHTML = `${node[i].start}`;
            newDIV.style.backgroundColor = "Skyblue";
            newDIV.style.position = "absolute";
            newDIV.style.left = `${x[node[i].start]}px`;
            newDIV.style.top = `${y[node[i].start] + 630}px`;

            newDIV2.setAttribute("class", "node");
            newDIV2.innerHTML = `${node[i].stop}`;
            newDIV2.style.backgroundColor = "Skyblue";
            newDIV2.style.position = "absolute";
            newDIV2.style.left = `${x[node[i].stop]}px`;
            newDIV2.style.top = `${y[node[i].stop] + 630}px`;

            // span 생성
            nodePad2.appendChild(newDIV);
            nodePad2.appendChild(newDIV2);

            // context2 생성
            context2 = canvas2.getContext("2d");

            // context2 속성 추가
            context2.beginPath();
            context2.moveTo(x[node[i].start], y[node[i].start]);
            context2.lineTo(x[node[i].stop], y[node[i].stop]);
            context2.strokeStyle = "black";
            context2.lineWidth = 0.5;

            // context2 그리기
            if(0){  // 간선 사이에 노드가 있을 경우
                for(var k = 0; k < index; k++){
                    if(nodePad.children[k].getBoundingClientRect() == context2.getBoundingClientRect()){
                        var warn = document.createElement("div");
                        warn.innerHTML = "간선과 노드가 맞닿습니다.";
                        nodePad.appendChild(warn);
                    }
                }
            } else {
            context2.stroke();
            context2.strokeText(node[i].weight,
            (x[node[i].start] + x[node[i].stop]) / 2,
            (y[node[i].start] + y[node[i].stop]) / 2);
            }
        }
    }
}

function prim(event) {
    // choose one node random
    randomInt = Math.floor(Math.random() * (index-1) + 1);

    var covered = [];
    var flag = false;
    var res_edges = []
    var queue = new PriorityQueue()
    firstnode = new Node(randomInt+"", null, 0);
    queue.enqueue(firstnode);

    var count = 0;
    while(queue.store.length > 0) {
        for(var i = 0; i < queue.store.length; i++) {
            console.log(count + ": " + queue.store[i].start + ", " + queue.store[i].stop);
        }
        count++;
        flag = false;

        var a = queue.dequeue();
        for(var i = 0; i < covered.length; i++){
            if(a[0].start === covered[i]){
                flag = true;
            }
        }
        if(flag === true) continue;
        else{
            covered.push(a[0].start);

            if(a[0].stop !== null){
                res_edges.push(new Node(a[0].start, a[0].stop, a[0].weight));
            }

            for(var i = 0; i < nodeList[a[0].start].length; i++){
                for(var j = 0; j < covered.length; j++){
                    if(nodeList[a[0].start][i][0] !== covered[j]){
                        flag = false;
                        continue;
                    }
                    else {
                        flag = true;
                        break;
                    }
                }
                if(flag === true) break;
                else{
                    queue.enqueue(new Node(nodeList[a[0].start][i][0], a[0].start, nodeList[a[0].start][i][1]));
                }
            }
        }
    }

    for(var i = 0; i < res_edges.length; i++)
        console.log(res_edges[i]);

    var primRange;
    if(event.target === pmResult) primRange = res_edges.length / 4;
    if(event.target === pfResult) primRange = res_edges.length;

    for(var i = 0; i < primRange; i++){
        // y += 630
        // print node in canvas1
        // span 생성
        var newDIV = document.createElement("span");
        var newDIV2 = document.createElement("span");

        // span 속성 추가
        newDIV.setAttribute("class", "node");
        newDIV.innerHTML = `${res_edges[i].start}`;
        newDIV.style.backgroundColor = "Skyblue";
        newDIV.style.position = "absolute";
        newDIV.style.left = `${x[res_edges[i].start]}px`;
        newDIV.style.top = `${y[res_edges[i].start] + 630}px`;

        newDIV2.setAttribute("class", "node");
        newDIV2.innerHTML = `${res_edges[i].stop}`;
        newDIV2.style.backgroundColor = "Skyblue";
        newDIV2.style.position = "absolute";
        newDIV2.style.left = `${x[res_edges[i].stop]}px`;
        newDIV2.style.top = `${y[res_edges[i].stop] + 630}px`;

        // span 생성
        nodePad2.appendChild(newDIV);
        nodePad2.appendChild(newDIV2);

        // context2 생성
        context2 = canvas2.getContext("2d");

        // context2 속성 추가
        context2.beginPath();
        context2.moveTo(x[res_edges[i].start], y[res_edges[i].start]);
        context2.lineTo(x[res_edges[i].stop], y[res_edges[i].stop]);
        context2.strokeStyle = "black";
        context2.lineWidth = 0.5;

        // context2 그리기
        if(0){  // 간선 사이에 노드가 있을 경우
            for(var k = 0; k < index; k++){
                if(nodePad.children[k].getBoundingClientRect() == context2.getBoundingClientRect()){
                    var warn = document.createElement("div");
                    warn.innerHTML = "간선과 노드가 맞닿습니다.";
                    nodePad.appendChild(warn);
                }
            }
        } else {
        context2.stroke();
        context2.strokeText(res_edges[i].weight,
        (x[res_edges[i].start] + x[res_edges[i].stop]) / 2,
        (y[res_edges[i].start] + y[res_edges[i].stop]) / 2);
        }
    }
}

function getParent(prt, a) {
    if(prt[a] == a) return a;
    return prt[a] = getParent(prt, prt[a])
}

function unionParent(prt, a, b) {
    a = getParent(prt, a);
    b = getParent(prt, b);
    if(a < b) prt[b] = a;
    else prt[a] = b;
}

function findParent(prt, a, b) {
    a = getParent(prt, a);
    b = getParent(prt, b);
    if(a == b) return true;
    else return false;
}

function clear(){
    while(nodePad2.lastChild != canvas2) {
        nodePad2.removeChild(nodePad2.lastChild);
    }
    context2.clearRect(0, 0, canvas2.width, canvas2.height);
    context2.beginPath();
    //alert("간선이 노드에 걸칩니다.");
}

nodePad.addEventListener("click", makeNode);
button.addEventListener("click", makeLine);
mResult.addEventListener("click", kruskal);
fResult.addEventListener("click", kruskal);
pmResult.addEventListener("click", prim);
pfResult.addEventListener("click", prim);
clearBtn.addEventListener("click", clear);
