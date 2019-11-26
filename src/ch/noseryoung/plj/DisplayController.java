package ch.noseryoung.plj;

public class DisplayController {

    public void showMenu(){
        System.out.println("Select which option you'd like to use\n" +
                "[1] to display the current data\n" +
                "[2] to display the forecast\n" +
                "[3] to display the statistiks for today\n" +
                "[4] to change the data\n" +
                "[x] to leave the menu"
        );
    }

    public void switchCase(String entry){
        switch(entry.toLowerCase()){
            case "1":
                System.out.println("Display 1");
                break;
            case "2":
                System.out.println("Display 2");
                break;
            case "3":
                System.out.println("Display 3");
                break;
            case "4":
                break;
            default:
                System.out.println("Please enter a valid value");
                break;
            case "x":
                break;
        }
    }

}
