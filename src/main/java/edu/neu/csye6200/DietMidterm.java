package edu.neu.csye6200;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * STUDENT SKELETON 100 TOTAL POINTS object model for high nutrition diet objects
 * 
 * 1. Complete code fragment [class DietMidterm] object model: SEE [** STUDENT TODO **]
 * 2. Use String[] CSV_STRINGS to develop diet objects to add to model
 * 3. Run model to show SORTED state of all diet objects in model 
 * 
 * GIVEN:
 *		String[] CSV_STRINGS
 *		interface DietableAPI
 *		interface DietableFactoryAPI
 *
 * 4. Develop following inner classes:
 * 		a. ConvertUtil
 * 		b. Drink
 * 		c. Dessert
 * 		d. Vegan
 * 		e. DrinkDietableFactory
 * 		f. DessertDietableFactory
 * 		g. VeganDietableFactory
 * 		h. DrinkDietableFactoryEnumSingleton
 * 		i. DessertDietableFactoryEagerSingleton
 * 		j. VeganDietableFactoryLazySingleton
 *  
 * @author Bhuvana Ravikumar
 *
 */



public class DietMidterm implements Runnable {
    public final static String VERSION = "3.12.30";
    public final static String[] DIET_CSV_STRINGS = {
        "101,20,0,3,1,3.49,Drink,refreshing healthy beverage",
        "102,40,5,6,0,2.99,Dessert,healthy snack",
        "103,80,20,2,30,13.99,Vegan,delicious entree"
 };



 private interface DietableAPI {
    int getId();
    int getCalorie();
    int getCarb();  
    int getSugar();
    int getProtein();
    double getPrice();
    String getName();
    String getDescription();
    String getCSV();
 
 default String dietString() {

    StringBuilder sb = new StringBuilder("Diet");
    sb.append(" # ").append(getId());
    sb.append(" $ ").append(getPrice()).append(", ");
    sb.append(" ").append(getName());
    sb.append(" \"").append(getDescription()).append(" \"").append(", ");
    sb.append("\"").append(getCSV()).append("\"").append(", ");
    sb.append(getCalorie()).append(" ").append("CALORIES ").append(", ");
    sb.append(getCarb()).append(" ").append("CARBORHYDRATES ").append(", ");
    sb.append(getSugar()).append(" ").append("SUGAR ").append(", ");
    sb.append(getProtein()).append(" ").append("PROTEIN ").append(", ");
    return sb.toString();
    }
 }



 private interface DietableFactoryAPI {
        DietableAPI getObject();
        DietableAPI getObject(String csvData);
    }

 private List<DietableAPI> dietList = new ArrayList<>();
 private List<DietableFactoryAPI> factoryList = new ArrayList<>();


 private void addObject(DietableAPI e) {
        dietList.add(e);
 }


 private void addObjects(List<DietableAPI> dietList) {
    this.dietList.addAll(dietList);
 }

 private void addFactory(DietableFactoryAPI f) {
    factoryList.add(f);
 }

 private void addFactories(List<DietableFactoryAPI> factoryList) {
 this.factoryList.addAll(factoryList);
 }

 private void sortObjects(Comparator<DietableAPI> c) {
    dietList.sort(c);
 }

 private void createDietObjects() {
    for (DietableFactoryAPI factory : factoryList) {
        addObject(factory.getObject());
    }
 }


 public void run() {
    System.out.println(this);
    }


 @Override
 public String toString() {
 StringBuilder sb = new StringBuilder(DietMidterm.class.getSimpleName());
 sb.append(": ").append(dietList.size()).append(" diet objects in list").append("\n");
    for (DietableAPI d : dietList) {
        sb.append(d).append("\n");
    }
 return sb.toString();
 }


 private static class ConvertUtil {
     static int toInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
     }



 static double toDouble(String str) {
         try {
             return Double.parseDouble(str);
         } catch (NumberFormatException e) {          
             return 0.0;
         }
    }
 }



 private static class Drink implements DietableAPI {
 private int id;
 private int calorie;
 private int carb;
 private int sugar;
 private int protein;
 private double price;
 private String name;
 private String description;


 Drink(String csvData) {
     String[] tokens = csvData.split(",");
     id = ConvertUtil.toInt(tokens[0]);
     calorie = ConvertUtil.toInt(tokens[1]);
     carb = ConvertUtil.toInt(tokens[2]);
     sugar = ConvertUtil.toInt(tokens[3]);
     protein = ConvertUtil.toInt(tokens[4]);
     price = ConvertUtil.toDouble(tokens[5]);
     name = tokens[6];
     description = tokens[7];
 }


 @Override
 public int getId() {
     return id;
 }



 @Override
 public int getCalorie() {
     return calorie;
 }


 @Override
 public int getCarb() {
     return carb;
}

 @Override
 public int getSugar() {
    return sugar;
 }

 @Override

 public int getProtein() {
    return protein;
 }

 @Override
 public double getPrice() {
    return price;
 }

 @Override
 public String getName() {
     return name;
}

 @Override
 public String getDescription() {
     return description;
}

 @Override
public String getCSV() {
    return id + "," + calorie + "," + carb + "," + sugar + "," + protein + "," + price + "," + name + "," + description;
}

 @Override
 public String toString() {
    return dietString();
 }
 }

 private static class Dessert implements DietableAPI {
 private int id;
 private int calorie;
 private int carb;
 private int sugar;
 private int protein;
 private double price;
 private String name;
 private String description;



 Dessert(String csvData) {
 String[] tokens = csvData.split(",");
 id = ConvertUtil.toInt(tokens[0]);
 calorie = ConvertUtil.toInt(tokens[1]);
 carb = ConvertUtil.toInt(tokens[2]);
 sugar = ConvertUtil.toInt(tokens[3]);
 protein = ConvertUtil.toInt(tokens[4]);
 price = ConvertUtil.toDouble(tokens[5]);
 name = tokens[6];
 description = tokens[7];
}


 @Override
 public int getId() {
 return id;
 }

 @Override
 public int getCalorie() {
 return calorie;
 }

 @Override
 public int getCarb() {
 return carb;
 }

 @Override
 public int getSugar() {
 return sugar;
 }

 @Override
 public int getProtein() {
 return protein;
 }

 @Override
 public double getPrice() {
 return price;
 }

 @Override
 public String getName() {
 return name;
 }

 @Override
 public String getDescription() {
 return description;
}
 
 @Override
 public String getCSV() {
 return id + "," + calorie + "," + carb + "," + sugar + "," + protein + "," + price + "," + name + "," + description;
 }

 @Override
 public String toString() {
 return dietString();
 }
 }


 private static class Vegan implements DietableAPI {
 private int id;
 private int calorie;
 private int carb;
 private int sugar;
 private int protein;
 private double price;
 private String name;
 private String description;

 
 Vegan(String csvData) {
 String[] tokens = csvData.split(",");
 id = ConvertUtil.toInt(tokens[0]);
 calorie = ConvertUtil.toInt(tokens[1]);
 carb = ConvertUtil.toInt(tokens[2]);
 sugar = ConvertUtil.toInt(tokens[3]);
 protein = ConvertUtil.toInt(tokens[4]);
 price = ConvertUtil.toDouble(tokens[5]);
 name = tokens[6];
 description = tokens[7];
 }



 @Override
 public int getId() {
 return id;
 }

 @Override
 public int getCalorie() {
 return calorie;
 }

 @Override
 public int getCarb() {
 return carb;
 }

 @Override
 public int getSugar() {
 return sugar;
 }

 @Override
 public int getProtein() {
 return protein;
 }

 @Override
 public double getPrice() {
 return price;
 }

 @Override
 public String getName() {
 return name;
 }

 @Override
 public String getDescription() {
 return description;
 }

 @Override
 public String getCSV() {
 return id + "," + calorie + "," + carb + "," + sugar + "," + protein + "," + price + "," + name + "," + description;
 }

 @Override
 public String toString() {
 return dietString();
 }
 }

 private static class DrinkDietableFactory implements DietableFactoryAPI {

 @Override
 public DietableAPI getObject() {
 return new Drink("101,20,0,3,1,3.49,Drink,refreshing healthy beverage");
 }

 @Override
 public DietableAPI getObject(String csvData) {
 return new Drink(csvData);
 }
 }


 private static class DessertDietableFactory implements DietableFactoryAPI {
 @Override
 public DietableAPI getObject() {
 return new Dessert("102,40,5,6,0,2.99,Dessert,healthy snack");
 }

 @Override
 public DietableAPI getObject(String csvData) {
 return new Dessert(csvData);
 }
 }

 private static class VeganDietableFactory implements DietableFactoryAPI {
 @Override
 public DietableAPI getObject() {
 return new Vegan("103,80,20,2,30,13.99,Vegan,delicious entree");
 }

 @Override
 public DietableAPI getObject(String csvData) {
 return new Vegan(csvData);
 }
}

 private static class DrinkDietableFactoryEnumSingleton implements DietableFactoryAPI {
 private static final DrinkDietableFactoryEnumSingleton INSTANCE = new DrinkDietableFactoryEnumSingleton();
 private DrinkDietableFactoryEnumSingleton() {
 }
 public static DrinkDietableFactoryEnumSingleton getInstance() {
 return INSTANCE;
 }


 @Override
 public DietableAPI getObject() {
 return new Drink("101,20,0,3,1,3.49,Drink,refreshing healthy beverage");
 }

 @Override
 public DietableAPI getObject(String csvData) {
 return new Drink(csvData);
 }
 }


 private static class DessertDietableFactoryEagerSingleton implements DietableFactoryAPI {
 private static final DessertDietableFactoryEagerSingleton INSTANCE = new DessertDietableFactoryEagerSingleton();
 private DessertDietableFactoryEagerSingleton() {
 }

 public static DessertDietableFactoryEagerSingleton getInstance() {
 return INSTANCE;
 }


 @Override
 public DietableAPI getObject() {
 return new Dessert("102,40,5,6,0,2.99,Dessert,healthy snack");
 }
 @Override
 public DietableAPI getObject(String csvData) {
 return new Dessert(csvData);
 }
 }


 private static class VeganDietableFactoryLazySingleton implements DietableFactoryAPI {
 private static VeganDietableFactoryLazySingleton instance;
 private VeganDietableFactoryLazySingleton() {
 }
 public static VeganDietableFactoryLazySingleton getInstance() {
 if (instance == null) {
 instance = new VeganDietableFactoryLazySingleton();
 }
 return instance;
 }


 @Override
 public DietableAPI getObject() {
 return new Vegan("103,80,20,2,30,13.99,Vegan,delicious entree");
 }

 @Override
 public DietableAPI getObject(String csvData) {
 return new Vegan(csvData);
 }
 }



 public static void demo() {
 System.out.println("\n\t" + DietMidterm.class.getName() + ".demo() [version ["
 + ""+ VERSION +" ]...");
 {
     DietMidterm model = new DietMidterm();
 System.out.println(model);
 model.addFactory(new DrinkDietableFactory());
 model.addFactory(new DessertDietableFactory());
 model.addFactory(new VeganDietableFactory());
 model.createDietObjects();
 model.run();
 
 System.out.println("\n\t SORT by ID (HIGHEST FIRST)...");
 model.sortObjects(Comparator.comparingInt(DietableAPI::getId).reversed());
 model.run();

 System.out.println("\n\t SORT by Calories (LOWEST FIRST)...");
 model.sortObjects(Comparator.comparingInt(DietableAPI::getCalorie));
 model.run();

 System.out.println("\n\t SORT by Carbohydrates (HIGHEST FIRST)...");
 model.sortObjects(Comparator.comparingInt(DietableAPI::getCarb).reversed());
 model.run();

 System.out.println("\n\t SORT by Sugars (LOWEST FIRST)...");
 model.sortObjects(Comparator.comparingInt(DietableAPI::getSugar));
 model.run();


 System.out.println("\n\t SORT by Protein (HIGHEST FIRST)...");
 model.sortObjects(Comparator.comparingInt(DietableAPI::getProtein).reversed());
 model.run();

 System.out.println("\n\t SORT by Price (LOWEST FIRST)...");
 model.sortObjects(Comparator.comparingDouble(DietableAPI::getPrice));
 model.run();
 
 System.out.println("\n\t SORT by Name using Anonymous inner class...");
 model.sortObjects(new Comparator<DietableAPI>() {
 @Override
 public int compare(DietableAPI o1, DietableAPI o2) {
     return o1.getName().compareTo(o2.getName());
 }
 });
 
 model.run();
 System.out.println("\n\t SORT by Description ...");
 model.sortObjects(Comparator.comparing(DietableAPI::getDescription));
 model.run();
 System.out.println("\n\t SORT by Default Natural order (i.e. Name) ...");

 Comparator<DietMidterm.DietableAPI> naturalOrderComparator = Comparator.comparing(DietMidterm.DietableAPI::getName);

 model.sortObjects(naturalOrderComparator);

// model.sortObjects(Comparator.naturalOrder());
 model.run();

 System.out.println("\n\t SORT by Name using Lambda...");
 model.sortObjects((o1, o2) -> o1.getName().compareTo(o2.getName()));
 model.run();
 }

 System.out.println("\n\t" + DietMidterm.class.getName() + ".demo()...");
 }

}

































































