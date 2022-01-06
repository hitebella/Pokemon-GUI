import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class Test{

    @org.junit.jupiter.api.Test
    void battleTest1v1(){
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        //the alolan legendary pokemon
        pokemons.add(new Pokemon(791,"solgaleo",791,34,2300,136,931,1,"psychic"));
        pokemons.add(new Pokemon(792,"lunala",792,40,1200,136,932,1,"psychic"));
        assertEquals("0 0 4 0 0 4",Pokemon.pokemonBattle(pokemons, "psychic", "psychic"));
        assert(pokemons.get(0).getType().equals(pokemons.get(1).getType()));
    }

    @org.junit.jupiter.api.Test
    void howTallShortEqual() {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new Pokemon(791,"solgaleo",791,34,2300,136,931,1,"psychic"));
        pokemons.add(new Pokemon(792,"lunala",792,40,1200,136,932,1,"psychic"));
        assertEquals("2 0 0", Pokemon.whatHeights(pokemons, 30));
        assert(pokemons.get(0).getHeight()<pokemons.get(1).getHeight());
    }

    @org.junit.jupiter.api.Test
    void whoIsTheStrongest(){
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new Pokemon(791,"solgaleo",791,34,2300,136,931,1,"psychic"));
        pokemons.add(new Pokemon(792,"lunala",792,40,1200,136,932,1,"psychic"));
        assertEquals("solgaleo psychic", Pokemon.getStrongestPokemon(pokemons,"psychic"));
        assert(pokemons.get(0).getXp()>=pokemons.get(1).getXp());
    }


}









