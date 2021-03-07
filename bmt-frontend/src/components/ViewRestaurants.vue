<template>
<div id="viewRestaurants">
  <div id="restaurants">
    <h1>Restaurants</h1>
    <div id="search">
      <h3>
        <span style="margin-right:20px"> Search for restaurants:</span>
      </h3>
      <input v-if="filterType == 'Restaurant Name' || filterType == 'Cuisine' || filterType == 'Food Options'" size="30" height="10" :placeholder="[[filterType]]" v-model="inputString">
      <br>
      <h4 v-if="filterType == 'Price'" style="margin-right: 20px">Price:</h4>
      <select v-if="filterType == 'Price'" style="width: 50px" v-model="price" placeholder="Price (1-5)">
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
      </select>
      <h4 v-if="filterType == 'Price Range'" style="margin-right: 20px">Min Price:</h4>
      <select v-if="filterType == 'Price Range'" style="width: 50px; margin-right: 20px" v-model="minPrice" placeholder="Price (1-5)">
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
      </select>
      <h4 v-if="filterType == 'Price Range'" style="margin-right: 20px">Max Price:</h4>
      <select v-if="filterType == 'Price Range'" style="width: 50px" v-model="maxPrice" placeholder="Price (1-5)">
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
      </select>
    </div>
    <div id="filter">
      <h3>
        <span style="margin-right:20px"> Filter by:</span>
      </h3>
      <select v-model="filterType" placeholder="Filter Type">
        <option>Restaurant Name</option>
        <option>Price</option>
        <option>Price Range</option>
        <option>Cuisine</option>
        <option>Food Options</option>
        <option>All Restaurants</option>
      </select>
      <br>
    </div>
    <div id="btn">
      <button v-if="filterType != '' || filterType == 'All Restaurants'" v-on:click="searchRestaurants(inputString, price, minPrice, maxPrice, filterType)">Search</button>
    </div>
    <br>
    <!-- <div id="restaurants-grid">
                <div v-for="c in restaurants" :key="c.id">
                    <RestaurantGrid :id="c.id" />\

                </div>
            </div> -->
    <table id="resto-table">
      <tr v-for="restaurant in restaurants" :key="restaurant.name">
        <div id="resto">
          <br>
          <h3>{{restaurant.name}}</h3>
          <a style="font-weight: bold;  text-decoration: underline" v-bind:href="getRestoPage(restaurant.id)">More info</a>
          <br>
          <br>
        </div>
        <br>
      </tr>
    </table>
    <h3 v-if="restaurants == ''">There are no such restaurants</h3>
  </div>
</div>
</template>

<script src="./javascript/viewRestaurants.js">

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

#resto {
  min-width: 100%;
  background-color: #ffffff;
}

#resto-table {
  min-width: 100%;
}

#restaurants {
  width: 70%;
  max-width: 70%;
  margin-left: auto;
  margin-right: auto;
}

#search, #filter {
  width: 100%;
  min-width: 100%;
}
</style>
