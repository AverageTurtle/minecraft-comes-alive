package mca.api.types;

import mca.enums.Gender;

public record ClothingGroup (
    String gender,
    String profession,
    int count,
    float chance) {

    public ClothingGroup() {
        this("", "", 0, 1);
    }

    public Gender getGender() {
        return Gender.byName(gender);
    }
    @Deprecated
    public String getProfession() {
        return profession;
    }
    @Deprecated
    public int getCount() {
        return count;
    }
    @Deprecated
    public float getChance() {
        return chance;
    }
}