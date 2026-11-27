public class Countries {
    //class that consists of all the data about each country stored in parallel arrays.
   String[] countryNames = {"Brazil", "France", "India", "Egypt", "China",
           "Italy", "Peru", "Australia", "Mexico", "Jordan",
           "Cambodia", "Japan", "United States", "United Kingdom", "Greece",
           "Spain", "Germany", "Canada", "United Arab Emirates", "South Africa",
           "Chile", "Tanzania", "Indonesia", "Thailand", "Netherlands",
           "Ireland", "Czech Republic", "Malaysia", "Vietnam", "Portugal"};
   String[] countryPops = {"212,000,000", "68,000,000", "1,430,000,000", "112,000,000", "1,410,000,000",
           "59,000,000", "34,000,000", "26,500,000", "129,000,000", "11,500,000",
           "17,000,000", "124,000,000", "335,000,000", "69,000,000", "10,400,000",
           "48,000,000", "84,000,000", "40,000,000", "10,000,000", "60,000,000",
           "19,500,000", "67,000,000", "278,000,000", "71,500,000", "17,900,000",
           "5,300,000", "10,900,000", "34,000,000", "100,000,000", "10,400,000"};
   String[] continents = {"South America", "Europe", "Asia", "Africa", "Asia",
           "Europe", "South America", "Oceania", "North America", "Asia",
           "Asia", "Asia", "North America", "Europe", "Europe",
           "Europe", "Europe", "North America", "Asia", "Africa",
           "South America", "Africa", "Asia", "Asia", "Europe",
           "Europe", "Europe", "Asia", "Asia", "Europe"};
   String[] landmarks = {"Christ the Redeemer", "Eiffel Tower", "Taj Mahal", "Great Pyramid of Giza", "Great Wall of China",
           "Colosseum", "Machu Picchu", "Sydney Opera House", "Chichen Itza", "Petra",
           "Angkor Wat", "Mount Fuji", "Statue of Liberty", "Big Ben", "Parthenon",
           "Sagrada Familia", "Brandenburg Gate", "CN Tower", "Burj Khalifa", "Table Mountain",
           "Moai statues of Easter Island", "Mount Kilimanjaro", "Borobudur", "Grand Palace in Bangkok", "Windmills of Kinderdijk",
           "Cliffs of Moher", "Charles Bridge", "Petronas Twin Towers", "Ha Long Bay", "Belem Tower"};

   //getters and setters.
   public String getName(int i) {
       return countryNames[i];
   }

   public String getPop(int i) {
       return countryPops[i];
   }

   public String getContinent(int i) {
       return continents[i];
   }

   public String getLandmark(int i) {
       return landmarks[i];
   }
}
