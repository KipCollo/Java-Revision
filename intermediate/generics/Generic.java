package intermediate.generics;

 class Generic<T> {
    
    T value;

    public void setValue(T value) {
        this.value = value;
  
    }

    public void show() {
        System.out.println(value.getClass().getName());
    }
  
}
    