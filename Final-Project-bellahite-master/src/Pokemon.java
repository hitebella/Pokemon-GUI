import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Pokemon {
    private int id;
    private String name;
    private int species_id;
    private int height;
    private int weight;
    private int xp;
    private int order;
    private int is_default;
    private String type;

    public Pokemon(int id, String name, int species_id, int height, int weight, int xp, int order, int is_default, String type) {
        this.id = id;
        this.name = name;
        this.species_id = species_id;
        this.height = height;
        this.weight = weight;
        this.xp = xp;
        this.order = order;
        this.is_default = is_default;
        this.type = type;
    }

    public Pokemon(String[] fields) {
        this.id = Integer.parseInt(fields[0]);
        this.name = fields[1];
        this.species_id = Integer.parseInt(fields[2]);
        this.height = Integer.parseInt(fields[3]);
        this.weight = Integer.parseInt(fields[4]);
        this.xp = Integer.parseInt(fields[5]);
        this.order = Integer.parseInt(fields[6]);
        this.is_default = Integer.parseInt(fields[7]);
        this.type = fields[8];
    }

    public String getType(){
        return type;
    }

    public String getName(){
        return name;
    }

    public int getXp(){
        return xp;
    }

    public int getHeight(){
        return height;
    }

    public String get_name_type(){
        String str = name + " is a " + type + " type";
        return str;
    }

    //done
    public static String getStrongestPokemon(ArrayList<Pokemon> p, String t){
        Pokemon strongest;

        ArrayList<Pokemon> a = new ArrayList<Pokemon>();

        int count = 0;
        for(int i = 0; i<p.size(); i++){
            if(p.get(i).getType().equals(t)){
                a.add((p.get(i)));
                //System.out.println(a.size());
            }
        }
        strongest = p.get(0);
        for(int i = 1; i<a.size(); i++){
            //some pokemon may have the same XP but strongest will still remain the first one on the list with the highest XP
            if(strongest.getXp()>=a.get(i).getXp()){
                strongest = strongest;
            }else{
                strongest = a.get(i);
            }
        }
//        String b = "hi b";
//        String[] l = b.split(" ");
//        System.out.println(Arrays.toString(l));

        return strongest.getName() + " " + strongest.getType();
    }


 //this works!! yay
    public static String whatHeights(ArrayList<Pokemon> p, int user_num){
        int taller = 0;
        int shorter = 0;
        int equal = 0;

        for(int i = 0; i<p.size(); i++){
            if(user_num==p.get(i).height){
                equal+=1;
            }else if(user_num>p.get(i).height){
                shorter+=1;
            }else if(user_num<p.get(i).height){
                taller +=1;
            }
        }
        //im separating the string by spaces so I can split them. its easier for me
        return taller + " " + shorter + " " + equal;
    }

    public static String pokemonBattle(ArrayList<Pokemon> p, String type1, String type2){

        ArrayList<Pokemon> type1pokes = new ArrayList<Pokemon>();
        ArrayList<Pokemon> type2pokes = new ArrayList<Pokemon>();

        //counter ints
        int wins1 = 0;
        int losses1 = 0;
        int ties1 = 0;

        int wins2 = 0;
        int losses2 = 0;
        int ties2 = 0;

        //first type pokemons in one arraylist
        for(int i = 0; i<p.size(); i++){
            if(p.get(i).getType().equals(type1)){
                type1pokes.add((p.get(i)));
            }
        }
        //sencond type of pokemons in another arraylist
        for(int i = 0; i<p.size(); i++){
            if(p.get(i).getType().equals(type2)){
                type2pokes.add((p.get(i)));
            }
        }

        for(int j = 0; j<type1pokes.size(); j++){
            for(int i = 0; i<type2pokes.size(); i++){
                if(type1pokes.get(j).getXp()>type2pokes.get(i).getXp()){
                    wins1++;
                    losses2++;
                }else if(type1pokes.get(j).getXp()<type2pokes.get(i).getXp()){
                    losses1++;
                    wins2++;
                }else if(type1pokes.get(j).getXp()==type2pokes.get(i).getXp()){
                    ties1++;
                    ties2++;
                }
                //System.out.println(type2pokes.get(i).getName() + " " + type2pokes.get(i).getXp());
            }
            //System.out.println(type1pokes.get(j).getName() + " " + type1pokes.get(j).getXp());
        }

        //will return a string of wins losses and ties of each type
        return(wins1 + " " + losses1 + " " + ties1 + " " + wins2 + " " + losses2 + " " + ties2);
    }


    public static ArrayList<Pokemon> readDataFile(String fileName) throws IOException {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        File file = new File(fileName);
        Scanner input = new Scanner(file);
        input.nextLine(); //skip headers
        int fieldCount = 9;
        while (input.hasNextLine()) {
            String[] fields = input.nextLine().split(",");

            if (fields.length != fieldCount) { //parsing error or problem with file
                System.out.println("expected 9 fields but counted " + fields.length);
                for (String str : fields)
                    System.out.println(str);
                throw new IOException();
            }
            Pokemon pokemon = new Pokemon(fields);
            pokemons.add(pokemon);
        }
        return pokemons;
    }
}