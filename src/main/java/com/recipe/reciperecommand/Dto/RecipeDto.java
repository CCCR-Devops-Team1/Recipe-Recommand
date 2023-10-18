package com.recipe.reciperecommand.Dto;

import lombok.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
@Data
public class RecipeDto {
    private Long from;
    private Long to;
    private Long count;
    private RecipesLinks _links;
    private List<Hit> hits;
}

// Hit.java
@Data
class Hit {
    private Recipe recipe;
    private HitLinks links;
}

// HitLinks.java
@Data
class HitLinks {
    private Next self;
}

// Next.java
@Data
class Next {
    private String href;
    private Title title;
}

// Title.java
enum Title {
    NEXT_PAGE, SELF;

    public String toValue() {
        switch (this) {
            case NEXT_PAGE: return "Next page";
            case SELF: return "Self";
        }
        return null;
    }

    public static Title forValue(String value) throws IOException {
        if (value.equals("Next page")) return NEXT_PAGE;
        if (value.equals("Self")) return SELF;
        throw new IOException("Cannot deserialize Title");
    }
}

// Recipe.java
@Data
class Recipe {
    private String uri;
    private String label;
    private String image;
    private Images images;
    private String source;
    private String url;
    private String shareAs;
    private Long yield;
    private List<DietLabel> dietLabels;
    private List<String> healthLabels;
    private List<Caution> cautions;
    private List<String> ingredientLines;
    private List<Ingredient> ingredients;
    private Double calories;
    private Double totalCO2Emissions;
    private Co2EmissionsClass co2EmissionsClass;
    private Double totalWeight;
    private Long totalTime;
    private List<String> cuisineType;
    private List<MealType> mealType;
    private List<String> dishType;
    private Map<String, Total> totalNutrients;
    private Map<String, Total> totalDaily;
    private List<Digest> digest;
}

// Caution.java
enum Caution {
    FODMAP, GLUTEN, SULFITES, WHEAT;

    public String toValue() {
        switch (this) {
            case FODMAP: return "FODMAP";
            case GLUTEN: return "Gluten";
            case SULFITES: return "Sulfites";
            case WHEAT: return "Wheat";
        }
        return null;
    }

    public static Caution forValue(String value) throws IOException {
        if (value.equals("FODMAP")) return FODMAP;
        if (value.equals("Gluten")) return GLUTEN;
        if (value.equals("Sulfites")) return SULFITES;
        if (value.equals("Wheat")) return WHEAT;
        throw new IOException("Cannot deserialize Caution");
    }
}

// Co2EmissionsClass.java
enum Co2EmissionsClass {
    F, G;

    public String toValue() {
        switch (this) {
            case F: return "F";
            case G: return "G";
        }
        return null;
    }

    public static Co2EmissionsClass forValue(String value) throws IOException {
        if (value.equals("F")) return F;
        if (value.equals("G")) return G;
        throw new IOException("Cannot deserialize Co2EmissionsClass");
    }
}

// DietLabel.java
enum DietLabel {
    HIGH_FIBER, HIGH_PROTEIN, LOW_CARB;

    public String toValue() {
        switch (this) {
            case HIGH_FIBER: return "High-Fiber";
            case HIGH_PROTEIN: return "High-Protein";
            case LOW_CARB: return "Low-Carb";
        }
        return null;
    }

    public static DietLabel forValue(String value) throws IOException {
        if (value.equals("High-Fiber")) return HIGH_FIBER;
        if (value.equals("High-Protein")) return HIGH_PROTEIN;
        if (value.equals("Low-Carb")) return LOW_CARB;
        throw new IOException("Cannot deserialize DietLabel");
    }
}

// Digest.java
@Data
class Digest {
    private Label label;
    private String tag;
    private SchemaOrgTag schemaOrgTag;
    private Double total;
    private Boolean hasRDI;
    private Double daily;
    private Unit unit;
    private List<Digest> sub;
}

// Label.java
enum Label {
    CALCIUM, CARBOHYDRATES_NET, CARBS, CARBS_NET, CHOLESTEROL, ENERGY, FAT, FIBER, FOLATE_EQUIVALENT_TOTAL, FOLATE_FOOD, FOLIC_ACID, IRON, MAGNESIUM, MONOUNSATURATED, NIACIN_B3, PHOSPHORUS, POLYUNSATURATED, POTASSIUM, PROTEIN, RIBOFLAVIN_B2, SATURATED, SODIUM, SUGARS, SUGARS_ADDED, SUGAR_ALCOHOLS, THIAMIN_B1, TRANS, VITAMIN_A, VITAMIN_B12, VITAMIN_B6, VITAMIN_C, VITAMIN_D, VITAMIN_E, VITAMIN_K, WATER, ZINC;

    public String toValue() {
        switch (this) {
            case CALCIUM: return "Calcium";
            case CARBOHYDRATES_NET: return "Carbohydrates (net)";
            case CARBS: return "Carbs";
            case CARBS_NET: return "Carbs (net)";
            case CHOLESTEROL: return "Cholesterol";
            case ENERGY: return "Energy";
            case FAT: return "Fat";
            case FIBER: return "Fiber";
            case FOLATE_EQUIVALENT_TOTAL: return "Folate equivalent (total)";
            case FOLATE_FOOD: return "Folate (food)";
            case FOLIC_ACID: return "Folic acid";
            case IRON: return "Iron";
            case MAGNESIUM: return "Magnesium";
            case MONOUNSATURATED: return "Monounsaturated";
            case NIACIN_B3: return "Niacin (B3)";
            case PHOSPHORUS: return "Phosphorus";
            case POLYUNSATURATED: return "Polyunsaturated";
            case POTASSIUM: return "Potassium";
            case PROTEIN: return "Protein";
            case RIBOFLAVIN_B2: return "Riboflavin (B2)";
            case SATURATED: return "Saturated";
            case SODIUM: return "Sodium";
            case SUGARS: return "Sugars";
            case SUGARS_ADDED: return "Sugars, added";
            case SUGAR_ALCOHOLS: return "Sugar alcohols";
            case THIAMIN_B1: return "Thiamin (B1)";
            case TRANS: return "Trans";
            case VITAMIN_A: return "Vitamin A";
            case VITAMIN_B12: return "Vitamin B12";
            case VITAMIN_B6: return "Vitamin B6";
            case VITAMIN_C: return "Vitamin C";
            case VITAMIN_D: return "Vitamin D";
            case VITAMIN_E: return "Vitamin E";
            case VITAMIN_K: return "Vitamin K";
            case WATER: return "Water";
            case ZINC: return "Zinc";
        }
        return null;
    }

    public static Label forValue(String value) throws IOException {
        if (value.equals("Calcium")) return CALCIUM;
        if (value.equals("Carbohydrates (net)")) return CARBOHYDRATES_NET;
        if (value.equals("Carbs")) return CARBS;
        if (value.equals("Carbs (net)")) return CARBS_NET;
        if (value.equals("Cholesterol")) return CHOLESTEROL;
        if (value.equals("Energy")) return ENERGY;
        if (value.equals("Fat")) return FAT;
        if (value.equals("Fiber")) return FIBER;
        if (value.equals("Folate equivalent (total)")) return FOLATE_EQUIVALENT_TOTAL;
        if (value.equals("Folate (food)")) return FOLATE_FOOD;
        if (value.equals("Folic acid")) return FOLIC_ACID;
        if (value.equals("Iron")) return IRON;
        if (value.equals("Magnesium")) return MAGNESIUM;
        if (value.equals("Monounsaturated")) return MONOUNSATURATED;
        if (value.equals("Niacin (B3)")) return NIACIN_B3;
        if (value.equals("Phosphorus")) return PHOSPHORUS;
        if (value.equals("Polyunsaturated")) return POLYUNSATURATED;
        if (value.equals("Potassium")) return POTASSIUM;
        if (value.equals("Protein")) return PROTEIN;
        if (value.equals("Riboflavin (B2)")) return RIBOFLAVIN_B2;
        if (value.equals("Saturated")) return SATURATED;
        if (value.equals("Sodium")) return SODIUM;
        if (value.equals("Sugars")) return SUGARS;
        if (value.equals("Sugars, added")) return SUGARS_ADDED;
        if (value.equals("Sugar alcohols")) return SUGAR_ALCOHOLS;
        if (value.equals("Thiamin (B1)")) return THIAMIN_B1;
        if (value.equals("Trans")) return TRANS;
        if (value.equals("Vitamin A")) return VITAMIN_A;
        if (value.equals("Vitamin B12")) return VITAMIN_B12;
        if (value.equals("Vitamin B6")) return VITAMIN_B6;
        if (value.equals("Vitamin C")) return VITAMIN_C;
        if (value.equals("Vitamin D")) return VITAMIN_D;
        if (value.equals("Vitamin E")) return VITAMIN_E;
        if (value.equals("Vitamin K")) return VITAMIN_K;
        if (value.equals("Water")) return WATER;
        if (value.equals("Zinc")) return ZINC;
        throw new IOException("Cannot deserialize Label");
    }
}

// SchemaOrgTag.java
enum SchemaOrgTag {
    CARBOHYDRATE_CONTENT, CHOLESTEROL_CONTENT, FAT_CONTENT, FIBER_CONTENT, PROTEIN_CONTENT, SATURATED_FAT_CONTENT, SODIUM_CONTENT, SUGAR_CONTENT, TRANS_FAT_CONTENT;

    public String toValue() {
        switch (this) {
            case CARBOHYDRATE_CONTENT: return "carbohydrateContent";
            case CHOLESTEROL_CONTENT: return "cholesterolContent";
            case FAT_CONTENT: return "fatContent";
            case FIBER_CONTENT: return "fiberContent";
            case PROTEIN_CONTENT: return "proteinContent";
            case SATURATED_FAT_CONTENT: return "saturatedFatContent";
            case SODIUM_CONTENT: return "sodiumContent";
            case SUGAR_CONTENT: return "sugarContent";
            case TRANS_FAT_CONTENT: return "transFatContent";
        }
        return null;
    }

    public static SchemaOrgTag forValue(String value) throws IOException {
        if (value.equals("carbohydrateContent")) return CARBOHYDRATE_CONTENT;
        if (value.equals("cholesterolContent")) return CHOLESTEROL_CONTENT;
        if (value.equals("fatContent")) return FAT_CONTENT;
        if (value.equals("fiberContent")) return FIBER_CONTENT;
        if (value.equals("proteinContent")) return PROTEIN_CONTENT;
        if (value.equals("saturatedFatContent")) return SATURATED_FAT_CONTENT;
        if (value.equals("sodiumContent")) return SODIUM_CONTENT;
        if (value.equals("sugarContent")) return SUGAR_CONTENT;
        if (value.equals("transFatContent")) return TRANS_FAT_CONTENT;
        throw new IOException("Cannot deserialize SchemaOrgTag");
    }
}

// Unit.java
enum Unit {
    EMPTY, G, KCAL, MG, UNIT_G;

    public String toValue() {
        switch (this) {
            case EMPTY: return "%";
            case G: return "g";
            case KCAL: return "kcal";
            case MG: return "mg";
            case UNIT_G: return "\u00b5g";
        }
        return null;
    }

    public static Unit forValue(String value) throws IOException {
        if (value.equals("%")) return EMPTY;
        if (value.equals("g")) return G;
        if (value.equals("kcal")) return KCAL;
        if (value.equals("mg")) return MG;
        if (value.equals("\u00b5g")) return UNIT_G;
        throw new IOException("Cannot deserialize Unit");
    }
}

// Images.java
@Data
class Images {
    private Large thumbnail;
    private Large small;
    private Large regular;
    private Large large;
}

// Large.java
@Data
class Large {
    private String url;
    private Long width;
    private Long height;
}

// Ingredient.java

@Data
class Ingredient {
    private String text;
    private Double quantity;
    private String measure;
    private String food;
    private Double weight;
    private String foodCategory;
    private String foodID;
    private String image;
}

// MealType.java
enum MealType {
    BRUNCH, LUNCH_DINNER;

    public String toValue() {
        switch (this) {
            case BRUNCH: return "brunch";
            case LUNCH_DINNER: return "lunch/dinner";
        }
        return null;
    }

    public static MealType forValue(String value) throws IOException {
        if (value.equals("brunch")) return BRUNCH;
        if (value.equals("lunch/dinner")) return LUNCH_DINNER;
        throw new IOException("Cannot deserialize MealType");
    }
}

// Total.java
@Data
class Total {
    private Label label;
    private Double quantity;
    private Unit unit;
}

// RecipesLinks.java
@Data
class RecipesLinks {
    private Next next;
}

