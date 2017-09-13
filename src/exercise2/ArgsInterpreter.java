package exercise2;

import java.util.ArrayList;
import java.util.HashMap;

public class ArgsInterpreter {
    private HashMap<String, String> store;
    private ArrayList<String> undefined;
    private ArrayList<String> flags;
    private String[] raw;

    public ArgsInterpreter(String[] args) {
        store = new HashMap<>();
        raw = args.clone();
        flags = new ArrayList<>();
        undefined = new ArrayList<>();
        //loop through the arguments and sort them
        for (int i = 0; i < args.length; i++) {
            //check if it is a flag
            if (args[i].charAt(0) == '-') {
                flags.add(args[i]);
                if (args.length > i+1 && args[i+1].charAt(0) != '-' ) {
                    store.put(args[i], args[i+1]);
                }
            }else {
                undefined.add(args[i]);
            }
        }
    }

    public boolean isSet(String flag) {
        return flags.contains(flag);
    }

    public String getValue(String key) {
        return store.get(key);
    }

    public String[] getUndefined() {
        return (String[]) undefined.toArray();
    }
}
