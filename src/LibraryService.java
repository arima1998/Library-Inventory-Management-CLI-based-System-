import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

public class LibraryService {
    private List<LibraryItem> inventory = new ArrayList<>();

    public void addItem(LibraryItem item){
        if(inventory.stream().anyMatch(a->a.getItemId() == item.getItemId())){
            throw new DuplicateItemException("Item with Same ID exists!!");
        }
        inventory.add(item);
    }

    public void removeItem(int itemId){
        boolean doesntExist = inventory.stream().noneMatch(a->a.getItemId() == itemId);
        if(doesntExist)throw  new ItemDoesntExistException("Item with ID: "+itemId+" doesnt Exist!");
        inventory.removeIf(a->a.getItemId() == itemId);
    }

    public List<LibraryItem>searchByTitle(String title){
        return inventory.stream()
                .filter(item->item.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<LibraryItem>listAllItems(){
        return new ArrayList<>(inventory);
    }

    public double calculateLateFeeByItem(int itemId,int lateDays) {
        LibraryItem item =inventory.stream()
                .filter(a->a.getItemId() == itemId)
                .findFirst()
                .orElseThrow(()->new ItemDoesntExistException("Does not Exist with Given ID"));
        return item.calculateLateFee(lateDays);
    }

    void populateService() {
        addItem(new Book(101, "The Great Gatsby", "F. Scott Fitzgerald", 1925, "Fiction", "123456789"));
        addItem(new Book(102, "1984", "George Orwell", 1949, "Dystopian", "987654321"));
        addItem(new Book(103, "To Kill a Mockingbird", "Harper Lee", 1960, "Fiction", "1122334455"));
        addItem(new Book(104, "Brave New World", "Aldous Huxley", 1932, "Science Fiction", "2233445566"));
        addItem(new Book(105, "Moby-Dick", "Herman Melville", 1851, "Adventure", "3344556677"));

        addItem(new Magazine(201, "National Geographic", "Various", 2020, "NatGeo", "145"));
        addItem(new Magazine(202, "Time", "Various", 2021, "Time Inc.", "300"));
        addItem(new Magazine(203, "The Economist", "Various", 2022, "Economist Group", "210"));
        addItem(new Magazine(204, "Scientific American", "Various", 2019, "Springer Nature", "75"));
        addItem(new Magazine(205, "Forbes", "Various", 2023, "Forbes Media", "500"));
    }





}
