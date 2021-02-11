<template>
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr />

    <label id="name" for="name"><b>Name</b></label
    ><br />
    <input type="text" placeholder="Enter Name" name="name" id="name" />

    <br /><label id="email" for="email"><b>Email</b></label
    ><br />
    <input type="text" placeholder="Enter Email" name="email" id="email" />

    <br /><label id="psw" for="psw"><b>Password</b></label
    ><br />
    <input type="password" placeholder="Enter Password" name="psw" id="psw" />

    <br /><label id="psw-repeat" for="psw-repeat"><b>Repeat Password</b></label
    ><br />
    <input
      type="password"
      placeholder="Repeat Password"
      name="psw-repeat"
      id="psw-repeat"
    />
    <br /><label id="accountType" for="accountType"><b>Select Account Type</b></label
    ><br />
    <select name="accountType" id="accountType">
      <option value="Customer">Customer</option>
      <option value="Restaurant Owner">Restaurant Owner</option>
    </select><br />

    <button type="submit" class="registerbtn">Register</button>
    <div class="container signinbtn">
      <p>Already have an account? <router-link to="/">Sign in</router-link>.</p>
    </div>
  </div>
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

select[name="accountType"] {
  width: 25%;
  padding: 16px 20px;
  border: none;
  border-radius: 5px;
  margin: 5px 0 22px 0;
  background-color: #f1f1f1;
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

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signinbtn {
  background-color: #f1f1f1;
  text-align: center;
  border: none;
}

label[id="name"],
[id="label2"] {
  right: 248px;
  position: relative;
}

label[id="email"] {
  right: 248px;
  position: relative;
}

label[id="psw"] {
  right: 230px;
  position: relative;
}

label[id="psw-repeat"] {
  right: 200px;
  position: relative;
}
</style>