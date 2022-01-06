import java.util.ArrayList;
import java.io.IOException;

/*you can ignore this
  this is for my own visualization
 */

public class Helpful {
    public static void main(String[] args) throws IOException {
        ArrayList<Pokemon> pokemons = Pokemon.readDataFile("data/alolan_pokemon.csv");
//        ArrayList<Pokemon> pokemons = new ArrayList<>();
//        pokemons.add(new Pokemon(791,"solgaleo",791,34,2300,136,931,1,"psychic"));
//        pokemons.add(new Pokemon(792,"lunala",792,40,1200,136,932,1,"psychic"));
//        System.out.println(Pokemon.getStrongestPokemon(pokemons,"psychic"));
//
//        System.out.println(pokemons.get(4).getXp());
//        System.out.println(Pokemon.getStrongestPokemon(pokemons,"water"));
//        System.out.println(Pokemon.whatHeights(pokemons, 2)+"\n"+Pokemon.pokemonBattle(pokemons,"bug","grass"));
        System.out.println(Pokemon.pokemonBattle(pokemons,"fairy","fire"));
        //System.out.println(pokemons.get(7).getType());
//        ArrayList<String> types = new ArrayList<String>();
//        for(int i = 0; i< pokemons.size(); i++){
//            if(types.contains(pokemons.get(i).getType())==false){
//                types.add(pokemons.get(i).getType());
//            }
//        }
//        System.out.println(types);

    }
}
