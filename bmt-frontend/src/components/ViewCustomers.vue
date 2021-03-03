<template>
<div id="viewCustomers">
  <div id="customers">
    <h2>Customers</h2>
    <table>
        <th>
          <td>Id</td>
          <td>Name</td>
          <td>Email</td>
          <td>Phone Number</td>
          <td># Reservations</td>
        </th>
        <tr v-for="customer in customers" :key="customer.id">
          <td>{{customer.id}}</td>
          <td>{{customer.name}}</td>
          <td>{{customer.email}}</td>
          <td>{{customer.phoneNumber}}</td>
          <td>{{customer.reservations.length}}</td>
        </tr>
    </table>
  </div>
</div>
</template>

<script src="./javascript/viewCustomers.js">

</script>

<style>
#viewCustomers {
  display: flex;
  justify-content: space-between;
  margin-left: 1em;
  margin-right: 1em;
}

#customers-grid {
  display: flex;
  flex-wrap: wrap;
  width: 100%;
  max-width: 100%;
}

#customers>div {
  display: flex;
  width: 100px;
}

#viewCustomers {
  width: 100%;
  position: fixed;
  z-index: 1;
  height: 100%;
  top: 10;
  overflow-x: hidden;
  padding-top: 20px;
  background-color: #8d99ae;
  border-left: 40px solid #2b2d42;
  border-right: 40px solid #2b2d42;
  border-top: 40px solid #2b2d42;
  border-bottom: 40px solid #2b2d42;
}

#customers {
  width: 70%;
  max-width: 70%;
  margin-left: auto;
  margin-right: auto;
}
</style>
