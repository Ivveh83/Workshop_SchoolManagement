package se.lexicon.sequencers;

public class StudentSequencer {

    private static int currentId;

    public static int nextId(){
        return ++currentId;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        StudentSequencer.currentId = currentId;
    }
}
