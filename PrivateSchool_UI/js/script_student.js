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
let v4=document.getElementById("sn");

v4.onkeyup=function(){
    var f=document.getElementById("f");
    var f1=document.getElementById("f1");
    if (v4.value.length>0 && v4.value.length<2){
        f.classList.remove("valid");
        f.classList.add("invalid");
        f.style.display='inline';
    }
    else if (v4.value.length>15){
        f.classList.remove("valid");
        f.classList.add("invalid");
        f.style.display='inline';
    }
    else{
        f.classList.remove("invalid");
        f.classList.add("valid");
        f.style.display='none';
    }
    if (v4.value.match(number) || v4.value.match(symbols)){
        f1.classList.remove("valid");
        f1.classList.add("invalid");
        f1.style.display='inline';
    }
    else{
        f1.style.display='none';
    }
}

let v5=document.getElementById("lsn");
v5.onkeyup=function(){
    var g=document.getElementById("g");
    var g1=document.getElementById("g1");
    if (v5.value.length>0 && v5.value.length<4){
        g.classList.remove("valid");
        g.classList.add("invalid");
        g.style.display='inline';
    }
    else if (v5.value.length>15){
        g.classList.remove("valid");
        g.classList.add("invalid");
        g.style.display='inline';
    }
    else{
        g.classList.remove("invalid");
        g.classList.add("valid");
        g.style.display='none';
    }
    if (v5.value.match(number) || v5.value.match(symbols)){
        g1.classList.remove("valid");
        g1.classList.add("invalid");
        g1.style.display='inline';
    }
    else{
        g1.style.display='none';
    }
}


let v6=document.getElementById("e_st_n");
v6.onkeyup=function(){
    var h=document.getElementById("h");
    var h1=document.getElementById("h1");
    if (v6.value.length>0 && v6.value.length<3){
        h.classList.remove("valid1");
        h.classList.add("invalid1");
        h.style.display='inline';
    }
    else if (v6.value.length>12){
        h.classList.remove("valid1");
        h.classList.add("invalid1");
        h.style.display='inline';
    }
    else{
        h.classList.remove("invalid1");
        h.classList.add("valid1");
        h.style.display='none';
    }
    if (v6.value.match(number) || v6.value.match(symbols)){
        h1.classList.remove("valid1");
        h1.classList.add("invalid1");
        h1.style.display='inline';
    }
    else{
        h1.style.display='none';
    }
}


let v7=document.getElementById("e_st_l");
v7.onkeyup=function(){
    var i=document.getElementById("i");
    var i1=document.getElementById("i1");
    if (v7.value.length>0 && v7.value.length<3){
        i.classList.remove("valid1");
        i.classList.add("invalid1");
        i.style.display='inline';
    }
    else if (v7.value.length>12){
        i.classList.remove("valid1");
        i.classList.add("invalid1");
        i.style.display='inline';
    }
    else{
        i.classList.remove("invalid1");
        i.classList.add("valid1");
        i.style.display='none';
    }
    if (v7.value.match(number) || v7.value.match(symbols)){
        i1.classList.remove("valid1");
        i1.classList.add("invalid1");
        i1.style.display='inline';
    }
    else{
        i1.style.display='none';
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
