// Класс Животные
class Animals {
    private String name;
    private String birthDate;
    
    public Animals(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }
    
    public String getName() {
        return name;
    }
    
    public String getBirthDate() {
        return birthDate;
    }
}