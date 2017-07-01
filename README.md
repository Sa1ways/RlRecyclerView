# RlRecyclerView
A expandable RecyclerView implements kinds of functional features ,such as HeaderView FooterView ,EmptyView ,NetworkErrorView .. U can custom those functional effects  as u wish
# Normal List
![image](https://github.com/Sa1ways/RlRecyclerView/blob/master/shots/normal.gif)
# Empty View
![image](https://github.com/Sa1ways/RlRecyclerView/blob/master/shots/empty.gif)
# NetworkErrorView
![image](https://github.com/Sa1ways/RlRecyclerView/blob/master/shots/network.gif)


＃ RecyclerView.Adapter
U can use extends the CommonAdapter to complete a recyclerView adapter when the itemType is just one,
and the MultiAdapter for multi types quickly .The usage is as follows:

# CommonAdapter<T>

public class CommonRvDemoAdapter extends CommonAdapter<String> {

    @Override
    public int getItemLayoutId() {
        return R.layout.layout_item;
    }

    @Override
    public void convert(ViewHolder holder, int position, String info) {
        ((TextView)holder.getView(R.id.tv)).setText("item position"+String.valueOf(position));
        ((TextView)holder.getView(R.id.tv)).setTextColor(Color.WHITE);
    }

}

# MultiAdapter in this way:

public class RvMultiTypeAdapter extends MultiTypeAdapter<String> {

    @Override
    public void addItemTypeDelegate() {
        mDelegateManager.addDelegate(new ItemTypeDelegate<String>() {
            @Override
            public int getItemLayoutId() {
                return 0;
            }

            @Override
            public boolean isTypeForItem(int position, String s) {
                return false;
            }

            @Override
            public void convert(ViewHolder holder, int position, String info) {

            }
        }).addDelegate(new ItemTypeDelegate<String>() {
            @Override
            public int getItemLayoutId() {
                return 0;
            }

            @Override
            public boolean isTypeForItem(int position, String s) {
                return false;
            }

            @Override
            public void convert(ViewHolder holder, int position, String info) {

            }
        });
    }

}

#Detail and Api:

for more details , Plz download the demo

To be continued( = - =)

#finally: issues are welcomed !


