
var course1={title:"Math",stream:"Analysis",type:"Full Time",sta_date:"2020-01-15",end_date:"2020-09-15"};
var course2={title:"Biology",stream:"Anatomy",type:"Part Time",sta_date:"2020-01-30",end_date:"2020-05-15"};
var course3={title:"History",stream:"Ancient History",type:"Full Time",sta_date:"2020-02-15",end_date:"2020-09-15"};

var trainer1={name:"Rita",lastname:"Antonopoulou",course:course1};
var trainer2={name:"Vaggelis",lastname:"Germanos",course:course2};
var trainer3={name:"Loukianos",lastname:"Kilaidonis",course:course3};

var student1={name:"Malvina",lastname:"Karali",dob:"1952-02-03",co_st:[course1,course2],iD:1};
var student2={name:"Tzeni",lastname:"Karezi",dob:"1932-01-12",co_st:[course2,course3],iD:2};
var student3={name:"Nikos",lastname:"Gkatsos",dob:"1911-12-08",co_st:[course3],iD:3};
var student4={name:"Manos",lastname:"Xatzidakis",dob:"1925-11-23",co_st:[course1,course3],iD:4};
var student5={name:"Lizeta",lastname:"Kalimeri",dob:"1969-05-09",co_st:[course1],iD:5};
var student6={name:"Aris",lastname:"Chatzistefanou",dob:"1982-05-15",co_st:[course1,course2],iD:6};

var trainers= [trainer1,trainer2,trainer3];
var courses = [course1,course2,course3];
var students = [student1,student2,student3,student4,student5,student6];


function check(id){
    if (id == "sCourse"){
            var value1=document.getElementById(id).value;

            for (var i=0;i<trainers.length;i++){
                var f=trainers[i].course.title;
                if (f == value1){
                    document.getElementById("cou_tra_n").value = trainers[i].name
                    document.getElementById("cou_tra_l").value = trainers[i].lastname;
                }
            }

            var sel_options=document.getElementById("s_co_Student");
            if (sel_options.length > 1){
                for(var m=1;m<sel_options.length;m++){
                sel_options.remove(m);
                }
            }
            
            for (var j=0;j<students.length;j++){
                for (var l=0;l<students[j].co_st.length;l++){
                    var h=students[j].co_st[l].title;
                    if (h == value1){
                        var option=document.createElement("option");
                        option.text=students[j].name + " " + students[j].lastname;
                        option.value=students[j].iD;
                        document.getElementById("s_co_Student").add(option);
                        document.getElementById("ouou").style.display='none';  
                    }
                }
            }



            if (value1 == "Math" ){
                document.forms["form2"]["title"].value=course1.title;
                document.forms["form2"]["stream"].value=course1.stream;
                document.forms["form2"]["type"].value=course1.type;
                document.forms["form2"]["st_date"].value=course1.sta_date;
                document.forms["form2"]["end_date"].value=course1.end_date;
            }
            else if (value1 == "Biology" ){
                document.forms["form2"]["title"].value=course2.title;
                document.forms["form2"]["stream"].value=course2.stream;
                document.forms["form2"]["type"].value=course2.type;
                document.forms["form2"]["st_date"].value=course2.sta_date;
                document.forms["form2"]["end_date"].value=course2.end_date;
            }
            else{
                document.forms["form2"]["title"].value=course3.title;
                document.forms["form2"]["stream"].value=course3.stream;
                document.forms["form2"]["type"].value=course3.type;
                document.forms["form2"]["st_date"].value=course3.sta_date;
                document.forms["form2"]["end_date"].value=course3.end_date;
            }
            document.getElementById("form_editcourse").style.display="block";
    }

    else if (id == "sTrainer"){
        var value2=document.getElementById(id).value;
        
        if (value2 == "1" ){
            document.forms["form3"]["trname"].value=trainer1.name;
            document.forms["form3"]["trlastname"].value=trainer1.lastname;
            document.forms["form3"]["ch1"].checked=true;
            document.forms["form3"]["ch2"].checked=false;
            document.forms["form3"]["ch3"].checked=false;
        }
        else if (value2 == "2" ){
            document.forms["form3"]["trname"].value=trainer2.name;
            document.forms["form3"]["trlastname"].value=trainer2.lastname;
            document.forms["form3"]["ch1"].checked=false;
            document.forms["form3"]["ch2"].checked=true;
            document.forms["form3"]["ch3"].checked=false;
        }
        else{
            document.forms["form3"]["trname"].value=trainer3.name;
            document.forms["form3"]["trlastname"].value=trainer3.lastname;
            document.forms["form3"]["ch1"].checked=false;
            document.forms["form3"]["ch2"].checked=false;
            document.forms["form3"]["ch3"].checked=true;
        }
        document.getElementById("form_editrainer").style.display="block";
    }
    else{
        
        var value3=document.getElementById(id).value;
        if (value3 == "1"){
            document.forms["form4"]["stname"].value=student1.name;
            document.forms["form4"]["stlastname"].value=student1.lastname;
            document.forms["form4"]["dob"].value=student1.dob;
            document.forms["form4"]["ch1"].checked=true;
            document.forms["form4"]["ch2"].checked=true;
            document.forms["form4"]["ch3"].checked=false;
        }
        else if (value3 == "2"){
            document.forms["form4"]["stname"].value=student2.name;
            document.forms["form4"]["stlastname"].value=student2.lastname;
            document.forms["form4"]["dob"].value=student2.dob;
            document.forms["form4"]["ch1"].checked=true;
            document.forms["form4"]["ch2"].checked=false;
            document.forms["form4"]["ch3"].checked=true;
        }
        else if (value3 == "3"){
            document.forms["form4"]["stname"].value=student3.name;
            document.forms["form4"]["stlastname"].value=student3.lastname;
            document.forms["form4"]["dob"].value=student3.dob;
            document.forms["form4"]["ch1"].checked=false;
            document.forms["form4"]["ch2"].checked=false;
            document.forms["form4"]["ch3"].checked=true;
        }
        else if (value3 == "4"){
            document.forms["form4"]["stname"].value=student4.name;
            document.forms["form4"]["stlastname"].value=student4.lastname;
            document.forms["form4"]["dob"].value=student4.dob;
            document.forms["form4"]["ch1"].checked=true;
            document.forms["form4"]["ch2"].checked=false;
            document.forms["form4"]["ch3"].checked=true;
        }
        else if (value3 == "5"){
            document.forms["form4"]["stname"].value=student5.name;
            document.forms["form4"]["stlastname"].value=student5.lastname;
            document.forms["form4"]["dob"].value=student5.dob;
            document.forms["form4"]["ch1"].checked=false;
            document.forms["form4"]["ch2"].checked=true;
            document.forms["form4"]["ch3"].checked=false;
        }
        else{
            document.forms["form4"]["stname"].value=student6.name;
            document.forms["form4"]["stlastname"].value=student6.lastname;
            document.forms["form4"]["dob"].value=student6.dob;
            document.forms["form4"]["ch1"].checked=false;
            document.forms["form4"]["ch2"].checked=true;
            document.forms["form4"]["ch3"].checked=true;
        }
        document.getElementById("form_edistudent").style.display="block";
    }
}

function editable(y){
    var arrayc=document.getElementsByClassName(y);
    for (var i=0;i<arrayc.length;i++){
        arrayc[i].removeAttribute('readonly');
    }
}

function updated(x){
        alert("Successfully Updated");
}


function select_value(){
    var x=document.getElementById("s_co_Student").value;
    for (var i=0;i<students.length;i++){
        if (students[i].iD == x){
            document.forms["form6"]["stname"].value=students[i].name;
            document.forms["form6"]["stlastname"].value=students[i].lastname;
            document.forms["form6"]["dob"].value=students[i].dob;
        }
    }
    document.getElementById("form_edistudent2").style.display="block";
}

function editable2(y){
    var arrayc=document.getElementsByClassName(y);
    for (var i=0;i<arrayc.length;i++){
        arrayc[i].removeAttribute('readonly');
        arrayc[i].value="";
    }
}