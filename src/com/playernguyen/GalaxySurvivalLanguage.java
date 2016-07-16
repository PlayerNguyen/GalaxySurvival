package com.playernguyen;

public enum GalaxySurvivalLanguage {

    VIETNAM("vi"), ENGLISH("en");

    private String domain;
    private GalaxySurvivalLanguage(String domain)
    {
        this.domain = domain;
    }

    public String getDomain() {
        return domain;
    }
    public static GalaxySurvivalLanguage domainFrom(String s)
    {
        switch (s)
        {
            case "vi": return VIETNAM;
            case "en": return ENGLISH;
            default: return null;
        }
    }
}