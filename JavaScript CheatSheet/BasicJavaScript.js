// Welcome page alerts
/*let user=prompt("What is your name?","Guest");
console.log("welcome",user);
let Agevar=confirm("Are you 18 years old ?");
if(Agevar){
	console.log("You are welcome");
}
else{
	console.log("You are restricted");
}*/

//-------------------------------------------------------------------------------------------------------

//To print on dom screen-
document.write("This paragraph come from document.write");

//To print on console-
console.log("Hello",5+5,"It is another line");
console.warn("This is warning on console");
console.error("This is error on console");

//-------------------------------------------------------------------------------------------------------

//variables
var num1=4;
var num2=6;
console.log("The addition of the numbers",num1+num2);//To print on console
document.write("<br>The addition of the numbers ",num1," and ",num2," is ",num1+num2);//To print on screen

//-------------------------------------------------------------------------------------------------------

// Datatypes
var number1=10;//Number
var number2=5.5;//Number
var string1="This is a string";//String
var string2='This is also a string';//String
var marks={ravi:34, ram:50, sam:50.5};//This is object variable/non primitive datatype
marks["jadu"]=100;//Assign new data into marks
var arr=[1,2,"ram",4,5];
let c=BigInt("420");//BigInt datatype

console.log("The addition of the numbers",number1+number2);
document.write("</br>The addition of the numbers ",number1+number2);
console.log(string1);
console.log(string2);
document.write("</br>",string1);
document.write("</br>",string2);
console.log(marks);
document.write("</br>",marks.ravi);
console.log(arr);
document.write("</br>",arr);
console.log(arr[2]);
document.write("</br>",arr[2]);

//-------------------------------------------------------------------------------------------------------

//Operators
var a=60;
var b=30;
console.log("The addition of the numbers",a,"and",b,"is",a+b)
document.write("</br>The addition of the numbers ",a," and ",b," is ",a+b)
console.log("The subtraction of the numbers",a,"and",b,"is",a-b)
document.write("</br>The subtraction of the numbers ",a," and ",b," is ",a-b)
console.log("The multiplication of the numbers",a,"and",b,"is",a*b)
document.write("</br>The multiplication of the numbers ",a," and ",b," is ",a*b)
console.log("The dividation of the numbers",a,"and",b,"is",a/b)
document.write("</br>The dividation of the numbers ",a," and ",b," is ",a/b)
a+=5// same as a+5
// var c=a;//Assignment
console.log(c);
console.log(c==b);
console.log(c<=b);
console.log(c>=b);
console.log(a==60? "yes":"no")//Turnery operator will print yes

//-------------------------------------------------------------------------------------------------------

// String
var myname="Atanu";
var surname=" Mondal";
console.log(myname+surname);
var temp=`${myname} is nice person`;
console.log(temp);
console.log("Length of name is " +myname.length);
document.getElementById("pid").innerHTML="This line is come from getElementById";
let name="atanu";
console.log(name.length);
console.log(name.toUpperCase());
console.log(name.toLowerCase());
console.log(name.slice(2));
console.log(name.slice(2,4));
console.log(name.replace("ata","santa"));
console.log(name.concat(" is a good boy"," okay?"));
let trimFunc="       atanu";
console.log(trimFunc.trim());

//-------------------------------------------------------------------------------------------------------

//function
function avg(n1,n2,n3)
{
	res=(n1+n2+n3)/3;
	return res;
}
var result=avg(5,10,15);
console.log(result);

//-------------------------------------------------------------------------------------------------------

//Conditional Operators
var myage=11;
if (myage>=18&&myage<=29)
{
	console.log("You are eligible");
}
else if(myage>=30){
	console.log("You are too old");
}
else{
	console.log("You are a kid now");
}

//-------------------------------------------------------------------------------------------------------

//Loops
console.log("For loop");
var arr=[0,1,2,3,4,5,6,7,8,9,10];
for(var i=0;i<arr.length;i++)//for loop
{
	console.log(arr[i]);
}
console.log("forEach loop");
arr.forEach(function(element)//forEach loop
{
	console.log(element);
})

console.log("For in loop");
let employee={name:"Atanu", salary:10000, job:"Web Developer"}//for in loop
for(key in employee){
	console.log(`The ${key} of employee is ${employee[key]}`);
}

console.log("while loop");
let j=0;
while(j<arr.length)//While loop
{
	console.log(arr[j]);
	j++;
}

console.log("Do-while loop");
let k=0;
do//do-while loop
{
	console.log(arr[k]);
	k++;
}
while(k<arr.length);

console.log("Break and continue");
for(var l=0;l<arr.length;l++)//Break and continue
{
	if(l==2)
	{
		continue;
	}
	if(l==6)
	{
		break;
	}
	console.log(arr[l]);
}

for(let i of arr){//for.. of method
	console.log(i);
}

// let age=prompt("what is age");//switch case
// age=parseInt(age);
// switch(age){
	// case  1:console.log("age is 1");break;
	// case  2:console.log("age is 2");break;
	// case  3:console.log("age is 3");break;
	// case  4:console.log("age is 4");break;
	// case  5:console.log("age is 5");
// }	

//-------------------------------------------------------------------------------------------------------

// Array
let myArr=["ant","camera",1,100,"String"]
let myArr2=["ant","camera",1,100,"String"]
let sortArr=["ram","tom","jerry","sam"];
console.log("Array methods");
console.log(myArr.length);//array length
console.log(myArr.toString());
let popElement=myArr.pop();//pop the last array element and return it
console.log(myArr.toString());
let shiftElement=myArr.shift();//remove the last element and return it
console.log(myArr.toString());
myArr.push("newElement",50);
console.log(myArr.toString());

let Today=new Date();
console.log(Today);
console.log(myArr.join("-"));//join - in the middle of array elements
myArr.unshift("newElement");//add new element to the begining of the array
delete myArr[1];//delete indexed element but does not change the length
console.log(myArr.concat(myArr2));//concat the two array
sortArr.sort();//sort the array in alphabetical order
myArr.reverse();//reverse the array

let str="atanu";
let strarr=Array.from(str);//convert the string into array
console.log(strarr);

let arrmap=[1,2,3,4]//Array mapping to create new array
let mappedarr= arrmap.map((value, index)=>{
	console.log(index, value);
	let res= value*value;
	return res;
})
console.log(mappedarr);

let arrfil=[1,2,3,4]//filterring the array
let afill= arrfil.filter((value)=>{
	res=value<4;
	return res;
})
console.log(afill);

let arrReduce=[1,2,3,4]//reduce function that multiply all the elements
let ared= arrReduce.reduce((first,second)=>{
	res=first*second;
	return res;
})
console.log(ared);

//-------------------------------------------------------------------------------------------------------

// Function
window.onload=function()
{
	//console.log("The document was loaded");
	// alert("The document was loaded");
}
sum=(a,b)=>{//Arrow function
	return a+b;
}
let Sumresult=sum(5,10);
console.log(Sumresult);
let Myname="Atanu";
let mymessage="Hello"
function greet(greetName,greetMessage)
{
	console.log(greetMessage+" "+greetName)
	console.log(greetName+", You are a good person");
}
greet(Myname,mymessage);

//-------------------------------------------------------------------------------------------------------

// Dom Navigation
let nav=document.getElementById("nav");
console.log(nav);
let Qsel=document.querySelector("#nav>li");
console.log(Qsel);

// let a=document.body.childNodes; //for all child nodes
// let b=document.body.childNodes[5]; //for child node at index 5
// let c=document.body.firstElementChild; //for first child element
// let c=document.body.firstChild; //for first child
document.querySelector;//for selecting a css tag
document.querySelectorAll; //for selecting all css tags  
document.getElementById; //for selecting element by id
document.getElementsByClassName;//for selecting  all elements by class name
document.getElementsByName; //for selecting element by name
document.getElementsByTagName; //for selecting element by tag name

//-------------------------------------------------------------------------------------------------------

// Button toggle function
function btnclicked(){
	let para=document.getElementById("para");
	let btn=document.getElementById("btn");
	if(para.style.display!="none"){
		para.style.display="none";
	}
	else{
	para.style.display="inline";
}
}

//-------------------------------------------------------------------------------------------------------

//Event listener 
let para=document.getElementById("para");
para.addEventListener('mouseover', function font(){
	para.style.color="red";
})
para.addEventListener('mouseout', function font(){
	para.style.color="black";
})

//-------------------------------------------------------------------------------------------------------

//setInterval and setTimeout
function greet1(name, message){
	console.log("Hello good morning "+name+" "+message);
}
timeout=setTimeout(greet1, 2000, "Atanu,", "How are you?" );
clearTimeout(timeout);// to clear the settimeout function.
interval=setInterval(greet1, 2000,"Atanu"," ");
clearInterval(interval);
function displayTime(){
	time = new Date();
	document.getElementById('time').innerHTML=time;
}
setInterval(displayTime,1000);

//-------------------------------------------------------------------------------------------------------

// Date and Time functions
let newDate= new Date();
console.log("The date and time now- "+newDate);
// console.log(newDate.getDate());
// console.log(newDate.getMonth());
// console.log(newDate.getHours());
// console.log(newDate.getMinutes());
//-------------------------------------------------------------------------------------------------------

//Arrow Function
// setTimeout(()=> {
					// console.log("We are in setTimeout function")
				// }, 
// 1000);
let sum1=(a,b)=> a+b;
let average= a=> a/3;
let obj={
	names:["Ram", "sam", "jadu",],
	speak(){
		this.names.forEach(
		(names)=>{
			console.log("hello "+ names);
				})
		}
	}
obj.speak();

//-------------------------------------------------------------------------------------------------------

//Math function
let numA=4.555;
let numB=12;
console.log("The rounded value of  num a is "+ Math.round(numA));
console.log("3 to the power of num b is "+ Math.pow(numB,3));
console.log("The square root of number 36 is "+Math.sqrt(36));
console.log("The rounde up value of number a is "+Math.ceil(numA));
console.log("The rounde down value of number a is "+Math.floor(numA));
let randomNum= numA+(numB-numA)*Math.random();
console.log("Generated random number between numA and numB is "+Math.round(randomNum));

//-------------------------------------------------------------------------------------------------------

//JSON
let JsonObject={
	name:"Ram",
	course:"BCA",
	enroll:123456
}// It is a object 
console.log(JsonObject);
let JsonStr=JSON.stringify(JsonObject);// It is used for string the object
console.log(JsonStr);

JsonStr=JsonStr.replace("Ram","Sam");// It is used for replacing a data
console.log(JsonStr);

let JsonObj=JSON.parse(JsonStr);// It is used for parse the string to object
console.log(JsonObj);

//-------------------------------------------------------------------------------------------------------

//regular expression
const regex=/very/g;
let text="its very very dangerous very very risky";
console.log(text.replace(regex,"little"));//the regex will replace the "very" with "little" globally.

//-------------------------------------------------------------------------------------------------------

// lexical "this" working with arrow function
const data={
	name:"Atanu",
	role:"coder",
	showData:function(){
		setTimeout(()=>{
			console.log(`The name is ${this.name} and role is ${this.role}`);
		},2000
	)
}
}
data.showData();

//-------------------------------------------------------------------------------------------------------

// destructuring
	let arr=["ram","sam"];
	let [a,b]=arr; //The array elements will asign to the variables 
	console.log(a);
	console.log(b);

	let {c,d}={c:"tom",d:"jerry"} //another example of setting variables
	console.log(c);
	console.log(d);

// spread syntax
	let arr1=[2,4,6];
	let sum= (v1,v2,v3)=>{
		return v1+v2+v3;
	}
	let sumres=sum(...arr1); //"..." is mandatory
	console.log(sumres);

// changing a object value
let myobj={
	name:"ram",
	role:"coder",
	company:"amazon"
}
console.log(myobj);
console.log({...myobj, name:"sam"});

//-------------------------------------------------------------------------------------------------------

// closure
function init(){
	var name1="atanu";
	function show(){
		console.log("the name is",name1);
	}
	return show; // the function will return the logic and also the variable reference
}
let print=init();
print();