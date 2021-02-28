<template>
  <div class="container">
    <h1>Modify Restaurant Owner Information</h1>
    <p>Modify your account details and save your changes.</p>
    <hr />
    <!-- set all the place holders to current value except password -->
    <label id="name-label" for="name-label"><b>Name</b></label
    ><br />
    <input type="text" placeholder="current name" name="name" id="name" />

    <br /><label id="email-label" for="email-label"><b>Email</b></label
    ><br />
    <input type="text" placeholder="current email" name="email" id="email" />

    <p>If you want to modify your password, please enter the old and new password</p>

    <br /><label id="old-psw-label" for="old-psw-label"><b>Old Password</b></label
    ><br />
    <input type="password" placeholder="Enter Old Password" name="old-psw" id="old-psw" />

    <br /><label id="new-psw-label" for="new-psw-label"><b>New Password</b></label
    ><br />
    <input
      type="password"
      placeholder="Enter New Password"
      name="new-psw"
      id="new-psw"
    />

    <br /><label id="new-repeat-psw-label" for="new-repeat-psw-label"><b>New Password Again</b></label
    ><br />
    <input
      type="password"
      placeholder="Enter New Password Again"
      name="new-psw-repeat"
      id="new-psw-repeat"
    />

    
    <!-- v-on click to save changes-->
    <button type="save-changes" class="saveownerbtn" >Save Changes</button>
   <!-- v-on click to go back to main page??-->
   <button type="cancel" class="cancelbtn"> Cancel </button>
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
input[name="name"], [name="email"], [name="old-psw"], [name="new-psw"],[name="new-psw-repeat"] {
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
.saveownerbtn {
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

.saveownerbtn:hover {
  opacity: 1;
}
.cancelbtn {
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

.cancelbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
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

<script>

</script>