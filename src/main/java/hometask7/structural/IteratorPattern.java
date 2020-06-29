package hometask7.structural;

interface Iterator {
    public boolean hasNext();
    public Object next();
}

interface Container {
    public Iterator getIterator();
}

class CollectionofNames implements Container {

    public String name[]={"ABC", "DEF","XYZ","PQR","TUV"};

    @Override
    public Iterator getIterator() {
        return new CollectionofNamesIterate() ;
    }

    private class CollectionofNamesIterate implements Iterator {
        int i;
        @Override
        public boolean hasNext() {
            if (i<name.length){
                return true;
            }
            return false;
        }
        @Override
        public Object next() {
            if(this.hasNext()){
                return name[i++];
            }
            return null;
        }
    }
}

class IteratorPattern {
    public static void main(String[] args) {
        CollectionofNames collectionofNames = new CollectionofNames();

        for(Iterator iterator = collectionofNames.getIterator(); iterator.hasNext();){
            String name = (String)iterator.next();
            System.out.println("Name : " + name);
        }
    }
}
