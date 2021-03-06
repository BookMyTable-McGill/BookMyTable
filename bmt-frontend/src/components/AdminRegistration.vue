<template>
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an Administrative account.</p>
    <hr />

    <label id="name-label" for="name-label"><b>Name</b></label
    ><br />
    <input type="text" placeholder="Enter Name" name="name" id="nameAdmin" />

    <br /><label id="email-label" for="email-label"><b>Email</b></label
    ><br />
    <input type="text" placeholder="Enter Email" name="email" id="emailAdmin" />

    <br /><label id="psw-label" for="psw-label"><b>Password</b></label
    ><br />
    <input type="password" placeholder="Enter Password" name="psw" id="pswAdmin" />

    <br /><label id="psw-repeat-label" for="psw-repeat-label"><b>Repeat Password</b></label
    ><br />
    <input
      type="password"
      placeholder="Repeat Password"
      name="psw-repeat"
      id="psw-repeatAdmin"
    />

    <br />
    <button type="submit" class="registerbtn" v-on:click="createAdmin()">Register</button>
    
</template>

<style>
* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
}

/* Half-width input fields */
input[name="name"], [name="email"], [name="psw"], [name="psw-repeat"] {
  width: 50%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  border-radius: 5px;
  background: #f1f1f1;
}

input[type="text"]:focus,
input[type="password"]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}


/* Set a style for the submit/register button */
.registerbtn {
  background-color: #4d9aff;
  color: black;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  width: 50%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}


/* Set a grey background color and center the text of the "sign in" section */
.signinbtn {
  background-color: #f1f1f1;
  text-align: center;
  border: none;
}

label[id="nameAdmin"],
[id="label2"] {
  right: 248px;
  position: relative;
}

label[id="emailAdmin"] {
  right: 248px;
  position: relative;
}

label[id="pswAdmin"] {
  right: 230px;
  position: relative;
}

label[id="psw-repeatAdmin"] {
  right: 200px;
  position: relative;
}

</style>

<script src="./javascript/adminRegistration.js"></script>