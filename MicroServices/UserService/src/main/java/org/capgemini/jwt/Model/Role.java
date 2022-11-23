package org.capgemini.jwt.Model;

public enum Role {
    USER(3, new String[]{"read", "write"}),
    ADMIN(1,new String[]{"read","write","update","delete"}),
    MANAGER(2,new String[]{"read","write","update"});


    private final int id;
    private final String[] authorities;

    Role(int id, String[] authorities){
        this.id = id;
        this.authorities = authorities;
    }

    public String[] getAuthorities()
    {
        return this.authorities;
    }

}
