<template>
<div id="viewReservations">
  <div id="reservations">
    <h2>Reservations</h2>
    <table>
      <th>
          <td>Id</td>
          <td>Restaurant Name</td>
          <td>Group Size</td>
          <td>Date</td>
          <td>Start Time</td>
          <td>Table Number</td>
      </th>
      <tr v-for="reservation in reservations" :key="reservation.id">
          <td>{{reservation.id}}</td>
          <td>{{reservation.restaurant.name}}</td>
          <td>{{reservation.groupSize}}</td>
          <td>{{reservation.date}}</td>
          <td>{{reservation.startTime}}</td>
          <td>{{reservation.table.tableNumber}}</td>
      </tr>
    </table>
  </div>
</div>
</template>

<script src="./javascript/viewReservationHistory.js">

</script>

<style>
#viewReservations {
  display: flex;
  justify-content: space-between;
  margin-left: 1em;
  margin-right: 1em;
}

#reservations-grid {
  display: flex;
  flex-wrap: wrap;
  width: 100%;
  max-width: 100%;
}

#reservations>div {
  display: flex;
  width: 100px;
}

#viewReservations {
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

#reservations {
  width: 70%;
  max-width: 70%;
  margin-left: auto;
  margin-right: auto;
}
</style>
