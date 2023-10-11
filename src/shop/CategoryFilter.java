package shop;

@FunctionalInterface
public interface CategoryFilter {
    public boolean categoryFilter(Product product, String str);
}
