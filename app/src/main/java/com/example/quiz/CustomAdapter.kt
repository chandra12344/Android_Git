package com.example.quiz

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.quiztestapp.ItemsViewModel


class CustomAdapter(private val mList: List<ItemsViewModel>,val context:Context) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val view = LayoutInflater.from(parent.context)
			.inflate(R.layout.item, parent, false)

		return ViewHolder(view)
	}
	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
 var i:Int=0
		val ItemsViewModel = mList[position]
		val sharedPreference =  context.getSharedPreferences("PREFERENCE_NAME",Context.MODE_PRIVATE)
		var editor = sharedPreference.edit()
		holder.textView.text = ItemsViewModel.questionText
		holder.option1.text=ItemsViewModel.option1
		holder.option2.text=ItemsViewModel.option2
		holder.option3.text=ItemsViewModel.option3
		holder.option4.text=ItemsViewModel.option4
		holder.option1.background= ContextCompat.getDrawable(context, R.drawable.buttonborders)
		holder.option2.background= ContextCompat.getDrawable(context, R.drawable.buttonborders)
		holder.option3.background= ContextCompat.getDrawable(context, R.drawable.buttonborders)
		holder.option4.background= ContextCompat.getDrawable(context, R.drawable.buttonborders)
		holder.option1.setOnClickListener {
			editor.putString("userAns","A")
			editor.commit()
			holder.option1.background= ContextCompat.getDrawable(context, R.drawable.buttonborders1)
			holder.option2.background= ContextCompat.getDrawable(context, R.drawable.buttonborders)
			holder.option3.background= ContextCompat.getDrawable(context, R.drawable.buttonborders)
			holder.option4.background= ContextCompat.getDrawable(context, R.drawable.buttonborders)
		}
		holder.option2.setOnClickListener {
			editor.putString("userAns","B")
			editor.commit()
			holder.option1.background= ContextCompat.getDrawable(context, R.drawable.buttonborders)
			holder.option2.background= ContextCompat.getDrawable(context, R.drawable.buttonborders1)
			holder.option3.background= ContextCompat.getDrawable(context, R.drawable.buttonborders)
			holder.option4.background= ContextCompat.getDrawable(context, R.drawable.buttonborders)
		}
		holder.option3.setOnClickListener {
			editor.putString("userAns","C")
			editor.commit()
			holder.option1.background= ContextCompat.getDrawable(context, R.drawable.buttonborders)
			holder.option2.background= ContextCompat.getDrawable(context, R.drawable.buttonborders)
			holder.option3.background= ContextCompat.getDrawable(context, R.drawable.buttonborders1)
			holder.option4.background= ContextCompat.getDrawable(context, R.drawable.buttonborders)
		}
		holder.option4.setOnClickListener {
			editor.putString("userAns","D")
			editor.commit()
			holder.option1.background= ContextCompat.getDrawable(context, R.drawable.buttonborders)
			holder.option2.background= ContextCompat.getDrawable(context, R.drawable.buttonborders)
			holder.option3.background= ContextCompat.getDrawable(context, R.drawable.buttonborders)
			holder.option4.background= ContextCompat.getDrawable(context, R.drawable.buttonborders1)
		}
	}

	// return the number of the items in the list
	override fun getItemCount(): Int {
		return mList.size
	}

	// Holds the views for adding it to image and text
	class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
//		val imageView: ImageView = itemView.findViewById(R.id.imageview)
		val textView: AppCompatTextView = itemView.findViewById(R.id.question_text)
		val option1: AppCompatButton = itemView.findViewById(R.id.option1)
		val option2: AppCompatButton = itemView.findViewById(R.id.option2)
		val option3: AppCompatButton = itemView.findViewById(R.id.option3)
		val option4: AppCompatButton = itemView.findViewById(R.id.option4)
		val button: AppCompatButton = itemView.findViewById(R.id.next)
	}
}
