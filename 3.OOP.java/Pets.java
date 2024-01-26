// Класс Pets, наследуется от Животные
class Pets extends Animals {
    private String[] commands;
    
    public Pets(String name, String birthDate, String[] commands) {
        super(name, birthDate);
        this.commands = commands;
    }
    
    public String[] getCommands() {
        return commands;
    }

    public void setCommands(String[] newCommands) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCommands'");
    }
}