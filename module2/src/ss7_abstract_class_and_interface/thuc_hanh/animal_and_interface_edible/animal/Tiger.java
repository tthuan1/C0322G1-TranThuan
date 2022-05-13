package ss7_abstract_class_and_interface.thuc_hanh.animal_and_interface_edible.animal;

import ss7_abstract_class_and_interface.thuc_hanh.animal_and_interface_edible.Edible;
import ss7_abstract_class_and_interface.thuc_hanh.animal_and_interface_edible.animal.Animal;

public class Tiger extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Tiger: roarrrrr!";
    }

    @Override
    public String howToEat() {
        return "Giả cầy";
    }
}
