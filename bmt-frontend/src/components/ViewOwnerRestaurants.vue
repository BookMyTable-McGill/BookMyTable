<template>
<div id="viewRestaurants">
  <div id="restaurants">
    <h2>Restaurants</h2>
    <!-- <div id="restaurants-grid">
                <div v-for="c in restaurants" :key="c.id">
                    <RestaurantGrid :id="c.id" />\

                </div>
            </div> -->
    <table>
      <tr>
        <th v-for="restaurant in restaurants" :key="restaurant.name">
          <br>
          <a style="font-weight: bold;  text-decoration: underline" v-bind:href="getRestoPage(restaurant.id)">{{restaurant.name}}</a>
          <br>
        </th>
      </tr>
    </table>
  </div>
</div>
</template>

<script src="./javascript/viewOwnerRestaurants.js">

</script>

<style>
#viewRestaurants {
  display: flex;
  justify-content: space-between;
  margin-left: 1em;
  margin-right: 1em;
}

#restaurants-grid {
  display: flex;
  flex-wrap: wrap;
  width: 100%;
  max-width: 100%;
}

#restaurants>div {
  display: flex;
  width: 100px;
}

#viewRestaurants {
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

#restaurants {
  width: 70%;
  max-width: 70%;
  margin-left: auto;
  margin-right: auto;
}
</style>
