public class MySingleTon {
    static class MST{
        private static volatile MST mst;

        public MST getInstance(){
            if(mst == null)
                synchronized (mst){
                    if (mst == null){
                        mst = new MST();
                    }
                }
            return mst;
        }
    }

}
