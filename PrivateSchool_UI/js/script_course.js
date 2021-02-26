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
        document.getElementById("edit_tr_co").style.display = 'none' ;
        document.getElementById("edit_st_co").style.display = 'none';
        document.getElementById("add_assign_co").style.display = 'none';
        document.getElementById("ed_assign_co").style.display = 'none';
    }
    else{
        if (k.style.display == 'block'){
            k.style.display = 'none';
            document.getElementById("edit_tr_co").style.display= 'none';
            document.getElementById("edit_st_co").style.display= 'none';
            document.getElementById("add_assign_co").style.display= 'none';
            document.getElementById("ed_assign_co").style.display= 'none';

        }
        else{
            k.style.display = 'block';
            document.getElementById("edit_tr_co").style.display='block';
            document.getElementById("edit_st_co").style.display='block';
            document.getElementById("add_assign_co").style.display= 'block';
            document.getElementById("ed_assign_co").style.display= 'block';
        }
        y.style.display = 'none';

    }
}



//Validation
let number=/[0-9]/g;
let symbols=/[$-/:-?{-~!"^_`\[\]]/g;
let v1=document.getElementById("ttl");
v1.onkeyup=function(){
    var a=document.getElementById("a");
    var a1=document.getElementById("a1");
    if (v1.value.length>0 && v1.value.length<3){
        a.classList.remove("valid");
        a.classList.add("invalid");
        a.style.display='inline';
    }
    else if (v1.value.length>12){
        a.classList.remove("valid");
        a.classList.add("invalid");
        a.style.display='inline';
    }
    else{
        a.classList.remove("invalid");
        a.classList.add("valid");
        a.style.display='none';
    }

    if (v1.value.match(number) || v1.value.match(symbols)){
        a1.classList.remove("valid");
        a1.classList.add("invalid");
        a1.style.display='inline';
    }
    else{
        a1.style.display='none';
    }
}

let v2=document.getElementById("str");
v2.onkeyup=function(){
    var b=document.getElementById("b");
    var b1=document.getElementById("b1");
    if (v2.value.length>0 && v2.value.length<3){
        b.classList.remove("valid");
        b.classList.add("invalid");
        b.style.display='inline';
    }
    else if (v2.value.length>12){
        b.classList.remove("valid");
        b.classList.add("invalid");
        b.style.display='inline';
    }
    else{
        b.classList.remove("invalid");
        b.classList.add("valid");
        b.style.display='none';
    }
    if (v2.value.match(number) || v2.value.match(symbols)){
        b1.classList.remove("valid");
        b1.classList.add("invalid");
        b1.style.display='inline';
    }
    else{
        b1.style.display='none';
    }
}

let v3=document.getElementById("tp");
v3.onkeyup=function(){
    var c=document.getElementById("c");
    var c1=document.getElementById("c1");
    if (v3.value.length>0 && v3.value.length<3){
        c.classList.remove("valid");
        c.classList.add("invalid");
        c.style.display='inline';
    }
    else if (v3.value.length>12){
        c.classList.remove("valid");
        c.classList.add("invalid");
        c.style.display='inline';
    }
    else{
        c.classList.remove("invalid");
        c.classList.add("valid");
        c.style.display='none';
    }
    if (v3.value.match(number) || v3.value.match(symbols)){
        c1.classList.remove("valid");
        c1.classList.add("invalid");
        c1.style.display='inline';
    }
    else{
        c1.style.display='none';
    }
}


let v4=document.getElementById("e_co_ttl" );
v4.onkeyup=function(){
    var d=document.getElementById("d");
    var d1=document.getElementById("d1");
    if (v4.value.length>0 && v4.value.length<3){
        d.classList.remove("valid1");
        d.classList.add("invalid1");
        d.style.display='inline';
    }
    else if (v4.value.length>12){
        d.classList.remove("valid1");
        d.classList.add("invalid1");
        d.style.display='inline';
    }
    else{
        d.classList.remove("invalid1");
        d.classList.add("valid1");
        d.style.display='none';
    }
    if (v4.value.match(number) || v4.value.match(symbols)){
        d1.classList.remove("valid1");
        d1.classList.add("invalid1");
        d1.style.display='inline';
    }
    else{
        d1.style.display='none';
    }
}

let v5=document.getElementById("e_co_str" );
v5.onkeyup=function(){
    var e=document.getElementById("e");
    var e1=document.getElementById("e1");
    if (v5.value.length>0 && v5.value.length<3){
        e.classList.remove("valid1");
        e.classList.add("invalid1");
        e.style.display='inline';
    }
    else if (v5.value.length>12){
        e.classList.remove("valid1");
        e.classList.add("invalid1");
        e.style.display='inline';
    }
    else{
        e.classList.remove("invalid1");
        e.classList.add("valid1");
        e.style.display='none';
    }
    if (v5.value.match(number) || v5.value.match(symbols)){
        e1.classList.remove("valid1");
        e1.classList.add("invalid1");
        e1.style.display='inline';
    }
    else{
        e1.style.display='none';
    }
}

let v6=document.getElementById("e_co_tp" );
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

let v7=document.getElementById("cou_tra_n");
v7.onkeyup=function(){
    var g=document.getElementById("g");
    var g1=document.getElementById("g1");
    if (v7.value.length>0 && v7.value.length<3){
        g.classList.remove("valid2");
        g.classList.add("invalid2");
        g.style.display='inline';
    }
    else if (v7.value.length>12){
        g.classList.remove("valid2");
        g.classList.add("invalid2");
        g.style.display='inline';
    }
    else{
        g.classList.remove("invalid2");
        g.classList.add("valid2");
        g.style.display='none';
    }
    if (v7.value.match(number) || v7.value.match(symbols)){
        g1.classList.remove("valid2");
        g1.classList.add("invalid2");
        g1.style.display='inline';
    }
    else{
        g1.style.display='none';
    }
}

let v8=document.getElementById("cou_tra_l");
v8.onkeyup=function(){
    var h=document.getElementById("h");
    var h1=document.getElementById("h1");
    if (v8.value.length>0 && v8.value.length<3){
        h.classList.remove("valid2");
        h.classList.add("invalid2");
        h.style.display='inline';
    }
    else if (v8.value.length>12){
        h.classList.remove("valid2");
        h.classList.add("invalid2");
        h.style.display='inline';
    }
    else{
        h.classList.remove("invalid2");
        h.classList.add("valid2");
        h.style.display='none';
    }
    if (v8.value.match(number) || v8.value.match(symbols)){
        h1.classList.remove("valid2");
        h1.classList.add("invalid2");
        h1.style.display='inline';
    }
    else{
        h1.style.display='none';
    }
}

let v9=document.getElementById("as_ttl");
v9.onkeyup=function(){
    var k=document.getElementById("k");
    if (v9.value.length>0 && v9.value.length<3){
        k.classList.remove("valid3");
        k.classList.add("invalid3");
        k.style.display='inline';
    }
    else if (v9.value.length>12){
        k.classList.remove("valid3");
        k.classList.add("invalid3");
        k.style.display='inline';
    }
    else{
        k.classList.remove("invalid3");
        k.classList.add("valid3");
        k.style.display='none';
    }
}


let v10=document.getElementById("as_des");
v10.onkeyup=function(){
    var l=document.getElementById("l");
    if (v10.value.length>0 && v10.value.length<3){
        l.classList.remove("valid3");
        l.classList.add("invalid3");
        l.style.display='inline';
    }
    else if (v10.value.length>12){
        l.classList.remove("valid3");
        l.classList.add("invalid3");
        l.style.display='inline';
    }
    else{
        l.classList.remove("invalid3");
        l.classList.add("valid3");
        l.style.display='none';
    }
}


function submited(){
    var val=document.querySelectorAll(".valid");

    if (val.length<6){
        alert("Wrong Inputs");
    }
    else{
        alert("Successfully Submited");
        window.location.reload();
    }
}

function submited2(){
    var val=document.querySelectorAll(".valid3");
    if (val.length<2){
        alert("Wrong Inputs");
    }
    else{
        alert("Successfully Submited Assignment to Course : " + document.getElementById("sCourse").value);
        window.location.reload();
    }
}


function updated2(){
    var val=document.querySelectorAll(".valid1");

    if (val.length<6){
        alert("Wrong Inputs");
    }
    else{
        alert("Successfully Updated");
        window.location.reload();
    }
}

function updated3(){
    var val=document.querySelectorAll(".valid2");
    if (val.length<4){
        alert("Wrong Inputs");
    }
    else{
        alert("Successfully Updated");
        window.location.reload();
    }
}