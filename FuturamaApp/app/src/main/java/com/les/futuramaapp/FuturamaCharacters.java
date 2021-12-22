package com.les.futuramaapp;

public class FuturamaCharacters {
    private String name;
    private int imageResourcesId;

    public FuturamaCharacters(String name, int imageResourcesId) {
        this.name = name;
        this.imageResourcesId = imageResourcesId;
    }

    public static final FuturamaCharacters[] robotCharacters = {
            new FuturamaCharacters("Bender", R.drawable.bender),
            new FuturamaCharacters("Roberto", R.drawable.roberto),
            new FuturamaCharacters("Flexo", R.drawable.flexo)

    };

    public static final FuturamaCharacters[] humanCharacters = {
            new FuturamaCharacters("Fry", R.drawable.fry),
            new FuturamaCharacters("Amy", R.drawable.amy),
            new FuturamaCharacters("Scruffy", R.drawable.scruffy)
    };

    public static final FuturamaCharacters[] mutantCharacters = {
            new FuturamaCharacters("Leela", R.drawable.leela),
            new FuturamaCharacters("Zoidberg", R.drawable.zoidberg),
            new FuturamaCharacters("Kif", R.drawable.kif)
    };

    public String getName() {
        return name;
    }

    public int getImageResourcesId() {
        return imageResourcesId;
    }
}
