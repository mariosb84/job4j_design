package ru.job4j.ood.isp.menu;

import java.util.*;

public class SimpleMenu implements Menu {

    private final List<MenuItem> rootElements = new ArrayList<>();

    @Override
    public boolean add(String parentName, String childName, ActionDelegate actionDelegate) {
        if (findItem(childName).isEmpty()) {
            rootElements.add(new SimpleMenuItem(parentName, actionDelegate));
            return true;
        }
        if (parentName == ROOT) {
            rootElements.add(new SimpleMenuItem(childName, actionDelegate));
            return true;
        }
    return false;
    }

    @Override
    public Optional<MenuItemInfo> select(String itemName) {
        Optional<ItemInfo> itemInfo = findItem(itemName);
        if (itemInfo.isPresent()) {
            MenuItem menuItem = itemInfo.get().menuItem;
            String number = itemInfo.get().number;
            MenuItemInfo menuItemInfo = new MenuItemInfo(menuItem, number);
            return Optional.of(menuItemInfo);
        }
        return Optional.empty();
    }

    @Override
    public Iterator<MenuItemInfo> iterator() {
    return null;
    }

    private Optional<ItemInfo> findItem(String name) {
        var iterator = new DFSIterator();
        while (iterator.hasNext()) {
            var item = iterator.next();
            if (item.menuItem.getName().equals(name)) {
                return Optional.of(item);
            }
        }
     return Optional.empty();
    }

    private static class SimpleMenuItem implements MenuItem {

        private String name;
        private List<MenuItem> children = new ArrayList<>();
        private ActionDelegate actionDelegate;

        public SimpleMenuItem(String name, ActionDelegate actionDelegate) {
            this.name = name;
            this.actionDelegate = actionDelegate;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public List<MenuItem> getChildren() {
            return children;
        }

        @Override
        public ActionDelegate getActionDelegate() {
            return actionDelegate;
        }
    }

    private class DFSIterator implements Iterator<ItemInfo> {

        Deque<MenuItem> stack = new LinkedList<>();

        Deque<String> numbers = new LinkedList<>();

        DFSIterator() {
            int number = 1;
            for (MenuItem item : rootElements) {
                stack.addLast(item);
                numbers.addLast(String.valueOf(number++).concat("."));
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public ItemInfo next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            MenuItem current = stack.removeFirst();
            String lastNumber = numbers.removeFirst();
            List<MenuItem> children = current.getChildren();
            int currentNumber = children.size();
            for (var i = children.listIterator(children.size()); i.hasPrevious();) {
                stack.addFirst(i.previous());
                numbers.addFirst(lastNumber.concat(String.valueOf(currentNumber--)).concat("."));
            }
            return new ItemInfo(current, lastNumber);
        }

    }

    private static class ItemInfo {

        MenuItem menuItem;
        String number;

        public ItemInfo(MenuItem menuItem, String number) {
            this.menuItem = menuItem;
            this.number = number;
        }
    }

    public static void main(String[] args) {
        final ActionDelegate STUB_ACTION = System.out::println;
        //Menu menu = new SimpleMenu();
        SimpleMenu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        menu.rootElements.forEach(MenuItem::getName);
        for (MenuItem menuItem : menu.rootElements) {
            System.out.println(menuItem);
        }
        System.out.println(menu.rootElements.size());
        //System.out.println(((SimpleMenu) menu).findItem("Сходить в магазин"));
    }

}