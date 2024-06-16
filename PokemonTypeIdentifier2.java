package pokemon;

import java.util.*;

public class PokemonTypeIdentifier2 {

    // Define the effectiveness values
    private static final double NORMAL = 1.0;
    private static final double SUPER_EFFECTIVE = 2.0;
    private static final double NOT_VERY_EFFECTIVE = 0.5;
    private static final double NO_EFFECT = 0.0;

    // Create a nested HashMap to store effectiveness
    private static final Map<String, Map<String, Double>> typeEffectiveness = new HashMap<>();
    private static final List<String> pokemonTypes = Arrays.asList("Normal", "Fire", "Water", "Grass", "Electric", "Ice",
            "Fighting", "Poison", "Ground", "Flying", "Psychic", "Bug", "Rock", "Ghost", "Dragon", "Dark", "Steel", "Fairy");

    static {
        // Initialize the effectiveness table
        // Normal type
        Map<String, Double> normal = new HashMap<>();
        normal.put("Rock", NOT_VERY_EFFECTIVE);
        normal.put("Ghost", NO_EFFECT);
        normal.put("Steel", NOT_VERY_EFFECTIVE);
        typeEffectiveness.put("Normal", normal);

        // Fire type
        Map<String, Double> fire = new HashMap<>();
        fire.put("Fire", NOT_VERY_EFFECTIVE);
        fire.put("Water", NOT_VERY_EFFECTIVE);
        fire.put("Grass", SUPER_EFFECTIVE);
        fire.put("Ice", SUPER_EFFECTIVE);
        fire.put("Bug", SUPER_EFFECTIVE);
        fire.put("Rock", NOT_VERY_EFFECTIVE);
        fire.put("Dragon", NOT_VERY_EFFECTIVE);
        fire.put("Steel", SUPER_EFFECTIVE);
        typeEffectiveness.put("Fire", fire);

        // Water type
        Map<String, Double> water = new HashMap<>();
        water.put("Fire", SUPER_EFFECTIVE);
        water.put("Water", NOT_VERY_EFFECTIVE);
        water.put("Grass", NOT_VERY_EFFECTIVE);
        water.put("Ground", SUPER_EFFECTIVE);
        water.put("Rock", SUPER_EFFECTIVE);
        water.put("Dragon", NOT_VERY_EFFECTIVE);
        typeEffectiveness.put("Water", water);

        // Grass type
        Map<String, Double> grass = new HashMap<>();
        grass.put("Fire", NOT_VERY_EFFECTIVE);
        grass.put("Water", SUPER_EFFECTIVE);
        grass.put("Grass", NOT_VERY_EFFECTIVE);
        grass.put("Poison", NOT_VERY_EFFECTIVE);
        grass.put("Ground", SUPER_EFFECTIVE);
        grass.put("Flying", NOT_VERY_EFFECTIVE);
        grass.put("Bug", NOT_VERY_EFFECTIVE);
        grass.put("Rock", SUPER_EFFECTIVE);
        grass.put("Dragon", NOT_VERY_EFFECTIVE);
        grass.put("Steel", NOT_VERY_EFFECTIVE);
        typeEffectiveness.put("Grass", grass);

        // Electric type
        Map<String, Double> electric = new HashMap<>();
        electric.put("Water", SUPER_EFFECTIVE);
        electric.put("Electric", NOT_VERY_EFFECTIVE);
        electric.put("Grass", NOT_VERY_EFFECTIVE);
        electric.put("Ground", NO_EFFECT);
        electric.put("Flying", SUPER_EFFECTIVE);
        electric.put("Dragon", NOT_VERY_EFFECTIVE);
        typeEffectiveness.put("Electric", electric);

        // Ice type
        Map<String, Double> ice = new HashMap<>();
        ice.put("Fire", NOT_VERY_EFFECTIVE);
        ice.put("Water", NOT_VERY_EFFECTIVE);
        ice.put("Grass", SUPER_EFFECTIVE);
        ice.put("Ice", NOT_VERY_EFFECTIVE);
        ice.put("Ground", SUPER_EFFECTIVE);
        ice.put("Flying", SUPER_EFFECTIVE);
        ice.put("Dragon", SUPER_EFFECTIVE);
        ice.put("Steel", NOT_VERY_EFFECTIVE);
        typeEffectiveness.put("Ice", ice);

        // Fighting type
        Map<String, Double> fighting = new HashMap<>();
        fighting.put("Normal", SUPER_EFFECTIVE);
        fighting.put("Ice", SUPER_EFFECTIVE);
        fighting.put("Poison", NOT_VERY_EFFECTIVE);
        fighting.put("Flying", NOT_VERY_EFFECTIVE);
        fighting.put("Psychic", NOT_VERY_EFFECTIVE);
        fighting.put("Bug", NOT_VERY_EFFECTIVE);
        fighting.put("Rock", SUPER_EFFECTIVE);
        fighting.put("Ghost", NO_EFFECT);
        fighting.put("Dark", SUPER_EFFECTIVE);
        fighting.put("Steel", SUPER_EFFECTIVE);
        fighting.put("Fairy", NOT_VERY_EFFECTIVE);
        typeEffectiveness.put("Fighting", fighting);

        // Poison type
        Map<String, Double> poison = new HashMap<>();
        poison.put("Grass", SUPER_EFFECTIVE);
        poison.put("Poison", NOT_VERY_EFFECTIVE);
        poison.put("Ground", NOT_VERY_EFFECTIVE);
        poison.put("Rock", NOT_VERY_EFFECTIVE);
        poison.put("Ghost", NOT_VERY_EFFECTIVE);
        poison.put("Steel", NO_EFFECT);
        poison.put("Fairy", SUPER_EFFECTIVE);
        typeEffectiveness.put("Poison", poison);

        // Ground type
        Map<String, Double> ground = new HashMap<>();
        ground.put("Fire", SUPER_EFFECTIVE);
        ground.put("Electric", SUPER_EFFECTIVE);
        ground.put("Grass", NOT_VERY_EFFECTIVE);
        ground.put("Poison", SUPER_EFFECTIVE);
        ground.put("Flying", NO_EFFECT);
        ground.put("Bug", NOT_VERY_EFFECTIVE);
        ground.put("Rock", SUPER_EFFECTIVE);
        ground.put("Steel", SUPER_EFFECTIVE);
        typeEffectiveness.put("Ground", ground);

        // Flying type
        Map<String, Double> flying = new HashMap<>();
        flying.put("Electric", NOT_VERY_EFFECTIVE);
        flying.put("Grass", SUPER_EFFECTIVE);
        flying.put("Fighting", SUPER_EFFECTIVE);
        flying.put("Bug", SUPER_EFFECTIVE);
        flying.put("Rock", NOT_VERY_EFFECTIVE);
        flying.put("Steel", NOT_VERY_EFFECTIVE);
        typeEffectiveness.put("Flying", flying);

        // Psychic type
        Map<String, Double> psychic = new HashMap<>();
        psychic.put("Fighting", SUPER_EFFECTIVE);
        psychic.put("Poison", SUPER_EFFECTIVE);
        psychic.put("Psychic", NOT_VERY_EFFECTIVE);
        psychic.put("Dark", NO_EFFECT);
        psychic.put("Steel", NOT_VERY_EFFECTIVE);
        typeEffectiveness.put("Psychic", psychic);

        // Bug type
        Map<String, Double> bug = new HashMap<>();
        bug.put("Fire", NOT_VERY_EFFECTIVE);
        bug.put("Grass", SUPER_EFFECTIVE);
        bug.put("Fighting", NOT_VERY_EFFECTIVE);
        bug.put("Poison", NOT_VERY_EFFECTIVE);
        bug.put("Flying", NOT_VERY_EFFECTIVE);
        bug.put("Psychic", SUPER_EFFECTIVE);
        bug.put("Ghost", NOT_VERY_EFFECTIVE);
        bug.put("Dark", SUPER_EFFECTIVE);
        bug.put("Steel", NOT_VERY_EFFECTIVE);
        bug.put("Fairy", NOT_VERY_EFFECTIVE);
        typeEffectiveness.put("Bug", bug);

        // Rock type
        Map<String, Double> rock = new HashMap<>();
        rock.put("Fire", SUPER_EFFECTIVE);
        rock.put("Ice", SUPER_EFFECTIVE);
        rock.put("Fighting", NOT_VERY_EFFECTIVE);
        rock.put("Ground", NOT_VERY_EFFECTIVE);
        rock.put("Flying", SUPER_EFFECTIVE);
        rock.put("Bug", SUPER_EFFECTIVE);
        rock.put("Steel", NOT_VERY_EFFECTIVE);
        typeEffectiveness.put("Rock", rock);

        // Ghost type
        Map<String, Double> ghost = new HashMap<>();
        ghost.put("Normal", NO_EFFECT);
        ghost.put("Psychic", SUPER_EFFECTIVE);
        ghost.put("Ghost", SUPER_EFFECTIVE);
        ghost.put("Dark", NOT_VERY_EFFECTIVE);
        typeEffectiveness.put("Ghost", ghost);

        // Dragon type
        Map<String, Double> dragon = new HashMap<>();
        dragon.put("Dragon", SUPER_EFFECTIVE);
        dragon.put("Steel", NOT_VERY_EFFECTIVE);
        dragon.put("Fairy", NO_EFFECT);
        typeEffectiveness.put("Dragon", dragon);

        // Dark type
        Map<String, Double> dark = new HashMap<>();
        dark.put("Fighting", NOT_VERY_EFFECTIVE);
        dark.put("Psychic", SUPER_EFFECTIVE);
        dark.put("Ghost", SUPER_EFFECTIVE);
        dark.put("Dark", NOT_VERY_EFFECTIVE);
        dark.put("Fairy", NOT_VERY_EFFECTIVE);
        typeEffectiveness.put("Dark", dark);

        // Steel type
        Map<String, Double> steel = new HashMap<>();
        steel.put("Fire", NOT_VERY_EFFECTIVE);
        steel.put("Water", NOT_VERY_EFFECTIVE);
        steel.put("Electric", NOT_VERY_EFFECTIVE);
        steel.put("Ice", SUPER_EFFECTIVE);
        steel.put("Rock", SUPER_EFFECTIVE);
        steel.put("Steel", NOT_VERY_EFFECTIVE);
        steel.put("Fairy", SUPER_EFFECTIVE);
        typeEffectiveness.put("Steel", steel);

        // Fairy type
        Map<String, Double> fairy = new HashMap<>();
        fairy.put("Fire", NOT_VERY_EFFECTIVE);
        fairy.put("Fighting", SUPER_EFFECTIVE);
        fairy.put("Poison", NOT_VERY_EFFECTIVE);
        fairy.put("Dragon", SUPER_EFFECTIVE);
        fairy.put("Dark", SUPER_EFFECTIVE);
        fairy.put("Steel", NOT_VERY_EFFECTIVE);
        typeEffectiveness.put("Fairy", fairy);
    }

    public static double getEffectiveness(String moveType, String type1, String type2) {
        double effectiveness1 = typeEffectiveness.getOrDefault(moveType, Collections.emptyMap()).getOrDefault(type1, NORMAL);
        double effectiveness2 = typeEffectiveness.getOrDefault(moveType, Collections.emptyMap()).getOrDefault(type2, NORMAL);
        return effectiveness1 * effectiveness2;
    }

    public static List<String> identifyTypes(Map<String, Double> moveEffectiveness) {
        List<String> possibleTypes = new ArrayList<>();

        for (String type1 : pokemonTypes) {
            for (String type2 : pokemonTypes) {
                if (type1.equals(type2)) {
                    // Check for single type Pokémon
                    boolean matchesSingleType = true;
                    for (Map.Entry<String, Double> entry : moveEffectiveness.entrySet()) {
                        String moveType = entry.getKey();
                        double effectiveness = entry.getValue();
                        double calculatedEffectiveness = getEffectiveness(moveType, type1, type1);

                        if (calculatedEffectiveness != effectiveness) {
                            matchesSingleType = false;
                            break;
                        }
                    }
                    if (matchesSingleType) {
                        possibleTypes.add(type1);
                    }
                    continue; // Skip same type combinations
                }

                boolean matches = true;
                for (Map.Entry<String, Double> entry : moveEffectiveness.entrySet()) {
                    String moveType = entry.getKey();
                    double effectiveness = entry.getValue();
                    double calculatedEffectiveness = getEffectiveness(moveType, type1, type2);

                    if (calculatedEffectiveness != effectiveness) {
                        matches = false;
                        break;
                    }
                }

                if (matches) {
                    possibleTypes.add(type1 + "/" + type2);
                }
            }
        }

        return possibleTypes;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> moveEffectiveness = new HashMap<>();
        Map<Integer, String> typeMapping = new HashMap<>();

        for (int i = 0; i < pokemonTypes.size(); i++) {
            typeMapping.put(i, pokemonTypes.get(i));
        }

        while (true) {
            System.out.println("Enter the move type (or type 'done' to finish). The options are:");
            for (Map.Entry<Integer, String> entry : typeMapping.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }

            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                System.out.println("Ending program...");
                break;
            }

            int moveTypeIndex;
            try {
                moveTypeIndex = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number corresponding to the move type.");
                continue;
            }

            if (!typeMapping.containsKey(moveTypeIndex)) {
                System.out.println("Invalid type number. Please enter a number from the list.");
                continue;
            }

            String moveType = typeMapping.get(moveTypeIndex);

            System.out.println("Enter the effectiveness (0 for no effect, 0.5 for not very effective, 1 for normal, 2 for super effective):");
            double effectiveness;
            try {
                effectiveness = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid effectiveness value.");
                continue;
            }

            moveEffectiveness.put(moveType, effectiveness);
            List<String> identifiedTypes = identifyTypes(moveEffectiveness);

            if (identifiedTypes.size() == 1) {
                System.out.println("The possible type of the Pokémon is: " + identifiedTypes.get(0));
                System.out.println("This is the Pokémon type you are looking for! Do you want to look up for another one? (yes/no)");
                String another = scanner.nextLine();
                if (another.equalsIgnoreCase("no")) {
                    System.out.println("Ending program...");
                    break;
                } else {
                    moveEffectiveness.clear();
                }
            } else if (identifiedTypes.size() == 2) {
                System.out.println("The possible types of the Pokémon are: " + identifiedTypes);
                System.out.println("This is the Pokémon types you are looking for! Do you want to look up for another one? (yes/no)");
                String another = scanner.nextLine();
                if (another.equalsIgnoreCase("no")) {
                    System.out.println("Ending program...");
                	break;
                } else {
                    moveEffectiveness.clear();
                }
            } else {
                System.out.println("The possible types of the Pokémon are: " + identifiedTypes);
            }
        }

        scanner.close();
    }
}
