package gregrdm.githubuserlistkotlin.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import gregrdm.githubuserlistkotlin.R;
import gregrdm.githubuserlistkotlin.network.model.UserItem;

/**
 *
 */

public class UserListRecyclerViewAdapter extends RecyclerView.Adapter<UserListRecyclerViewAdapter.ViewHolder> {

    private List<UserItem> users = Collections.emptyList();

    public UserListRecyclerViewAdapter(List<UserItem> users) {
        this.users = users;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(holder.userAvatar.getContext()).load(users.get(position).getAvatarUrl()).into(holder.userAvatar);
        holder.userLogin.setText(users.get(position).getLogin());
        holder.userType.setText(users.get(position).getType());
        holder.userScore.setText(String.valueOf(users.get(position).getScore()));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void setItems(List<UserItem> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView userAvatar;
        TextView userLogin;
        TextView userType;
        TextView userScore;

        public ViewHolder(View itemView) {
            super(itemView);

            userAvatar = (ImageView) itemView.findViewById(R.id.user_avatar);
            userLogin = (TextView) itemView.findViewById(R.id.user_login);
            userType = (TextView) itemView.findViewById(R.id.user_type);
            userScore = (TextView) itemView.findViewById(R.id.user_score);
        }
    }

}
