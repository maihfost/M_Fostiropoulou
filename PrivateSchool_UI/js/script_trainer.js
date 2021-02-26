function openform(x,z,p){
    var y = document.getElementById(x);
    var k = document.getElementById(z);
   
    if (p) {
        if (y.style.display == 'block'){
            y.style.display= 'none';
        }
        else{
            y.style.display = 'block';
        }
        k.style.display = 'none';
    }
    else{
        if (k.style.display == 'block'){
            k.style.display = 'none';
        }
        else{
            k.style.display = 'block';
        }
        y.style.display = 'none';

    }
}



let number=/[0-9]/g;
let symbols=/[$-/:-?{-~!"^_`\[\]]/g;
let v4=document.getElementById("nn");
v4.onkeyup=function(){
    var d=document.getElementById("d");
    var d1=document.getElementById("d1");
    if (v4.value.length>0 && v4.value.length<2){
        d.classList.remove("valid");
        d.classList.add("invalid");
        d.style.display='inline';
    }
    else if (v4.value.length>15){
        d.classList.remove("valid");
        d.classList.add("invalid");
        d.style.display='inline';
    }
    else{
        d.classList.remove("invalid");
        d.classList.add("valid");
        d.style.display='none';
    }
    if (v4.value.match(number) || v4.value.match(symbols)){
        d1.classList.remove("valid");
        d1.classList.add("invalid");
        d1.style.display='inline';
    }
    else{
        d1.style.display='none';
    }
}

let v5=document.getElementById("ln");
v5.onkeyup=function(){
    var e=document.getElementById("e");
    var e1=document.getElementById("e1");
    if (v5.value.length>0 && v5.value.length<4){
        e.classList.remove("valid");
        e.classList.add("invalid");
        e.style.display='inline';
    }
    else if (v5.value.length>15){
        e.classList.remove("valid");
        e.classList.add("invalid");
        e.style.display='inline';
    }
    else{
        e.classList.remove("invalid");
        e.classList.add("valid");
        e.style.display='none';
    }
    if (v5.value.match(number) || v5.value.match(symbols)){
        e1.classList.remove("valid");
        e1.classList.add("invalid");
        e1.style.display='inline';
    }
    else{
        e1.style.display='none';
    }
}

let v6=document.getElementById("e_tr_n");
v6.onkeyup=function(){
    var f=document.getElementById("f");
    var f1=document.getElementById("f1");
    if (v6.value.length>0 && v6.value.length<3){
        f.classList.remove("valid1");
        f.classList.add("invalid1");
        f.style.display='inline';
    }
    else if (v6.value.length>12){
        f.classList.remove("valid1");
        f.classList.add("invalid1");
        f.style.display='inline';
    }
    else{
        f.classList.remove("invalid1");
        f.classList.add("valid1");
        f.style.display='none';
    }
    if (v6.value.match(number) || v6.value.match(symbols)){
        f1.classList.remove("valid1");
        f1.classList.add("invalid1");
        f1.style.display='inline';
    }
    else{
        f1.style.display='none';
    }
}

let v7=document.getElementById("e_tr_l");
v7.onkeyup=function(){
    var g=document.getElementById("g");
    var g1=document.getElementById("g1");
    if (v7.value.length>0 && v7.value.length<3){
        g.classList.remove("valid1");
        g.classList.add("invalid1");
        g.style.display='inline';
    }
    else if (v7.value.length>12){
        g.classList.remove("valid1");
        g.classList.add("invalid1");
        g.style.display='inline';
    }
    else{
        g.classList.remove("invalid2");
        g.classList.add("valid1");
        g.style.display='none';
    }
    if (v7.value.match(number) || v7.value.match(symbols)){
        g1.classList.remove("valid1");
        g1.classList.add("invalid1");
        g1.style.display='inline';
    }
    else{
        g1.style.display='none';
    }
}


function submited(){
    var val=document.querySelectorAll(".valid");
    if (val.length<4){
        alert("Wrong Inputs");
    }
    else{
        alert("Successfully Submited");
        window.location.reload();
    }
}

function updated2(){
    var val=document.querySelectorAll(".valid1");
    if (val.length<4){
        alert("Wrong Inputs");
    }
    else{
        alert("Successfully Updated");
        window.location.reload();
    }
}