package kr.hs.emrim.tjdusdlfkrhd.internship;

class Countries {
 int id;
 String country;

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public String getCountry() {
  return country;
 }

 public void setCountry(String country) {
  this.country = country;
 }
 @Override
 public String toString() {
  return "Article{" +
          "id=" + id +
          ", country=" + country +
          '}';
 }
}
