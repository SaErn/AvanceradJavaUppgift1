package test.com.company;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Object {

    public static void main(String[] args){
        MyObject[] myObjects = new MyObject[50];

        makeArray(myObjects);

        for (MyObject object: myObjects){
            System.out.println(object);
        }

        List<MyObject> list =  Arrays.asList(myObjects);

        List newList = list
                .stream()
                .filter(x-> x.getValue() > 20)
                .collect(Collectors.toList());

        System.out.println(newList);

        OptionalDouble od = list
                .stream()
                .mapToInt(x -> x.getValue())
                .average();

        System.out.println("Medelvärde: " + od.getAsDouble());

        newList = list
                .stream()
                .map(x -> {
                   if (x.isBool() == true){
                       x.setName("True");
                   }
                   return x;
                })
                .collect(Collectors.toList());


        System.out.println(newList);
    }

    public static void makeArray(MyObject[] myObjects){

        for (int i = 0; i < myObjects.length; i++){
            boolean bool;
            String name = "name " + (int)(Math.random()*100)+1;
            int value = (int)(Math.random()*50)+1;
            if(value < 25){
                bool = true;
            }
            else{
                bool = false;
            }

            myObjects[i] = new MyObject(name, value, bool);
        }
    }
}
