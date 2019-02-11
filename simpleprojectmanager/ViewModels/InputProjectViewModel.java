package simpleprojectmanager.ViewModels;

public abstract class InputProjectViewModel {

    public abstract void confirmInput(String name, String description);

    protected String clean(String input) {
        return input.replace("\t", "    ").replace("\n", "    ");
    }
}
