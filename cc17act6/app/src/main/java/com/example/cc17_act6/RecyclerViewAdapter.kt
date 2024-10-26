package com.example.cc17_act6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    // Data lists
    private val itemDays = listOf(
        "Day 1", "Day 2", "Day 3", "Day 4", "Day 5", "Day 6", "Day 7", "Day 8", "Day 9", "Day 10",
        "Day 11", "Day 12", "Day 13", "Day 14", "Day 15", "Day 16", "Day 17", "Day 18", "Day 19", "Day 20",
        "Day 21", "Day 22", "Day 23", "Day 24", "Day 25", "Day 26", "Day 27", "Day 28", "Day 29", "Day 30"
    )

    private val itemTitles = listOf(
        "Pantry Staples", "Knife Skills 101", "Quick Breakfast", "Perfect Pasta", "Sheet Pan Dinners",
        "Soup from Scratch", "Bread Baking Basics", "Sauteing Skills", "Salad Creation", "Baking Cookies",
        "Spice it Up", "Comfort Food", "Cooking with Grains", "Sauce Mastery", "Roasting Veggies",
        "Marinades and Rubs", "Taco Night", "Homemade Pizza", "Slow Cooking", "Egg-cellent Technique",
        "Seafood Savvy", "Quick Pickling", "Vegan Cooking", "Dinner Party Prep", "Chocolate Indulgence",
        "Classic Omelet", "Dumpling Day", "International Flavors", "Leftover Transformation", "Reflect and Plan"
    )

    private val itemDetails = listOf(
        "Organize and inventory your pantry. Take out all items, discard expired products, and group similar items. Make a list of staple ingredients like rice, pasta, canned tomatoes, beans, spices, and oils that you'll need for the month, then plan to restock them if needed",
        "Practice knife techniques like dicing, mincing, julienne, and chiffonade. Use vegetables like onions, carrots, and bell peppers to get comfortable with different cuts. Watch a tutorial on proper knife grip and practice the \"claw grip\" to protect your fingers.",
        "Prepare three breakfast options you can make quickly. Try smoothies with fruit, spinach, and yogurt; overnight oats with chia seeds and fresh berries; and avocado toast with a poached egg. Experiment with toppings and flavors.",
        "Make a pasta dish with a basic tomato sauce. Sauté garlic in olive oil, add canned tomatoes, season with salt, pepper, and basil, and simmer. Cook pasta to al dente, then toss it in the sauce, finishing with grated Parmesan and fresh basil.",
        "Create a one-pan dinner with a protein and vegetables. Use chicken thighs, diced potatoes, and broccoli; season with olive oil, garlic powder, salt, and pepper. Roast at 425°F (220°C) for 30-40 minutes, turning halfway for even cooking.",
        "Make a simple soup, such as vegetable or minestrone. Sauté onions, carrots, and celery, then add broth and canned tomatoes. Add beans, pasta, or rice for texture, and season with herbs like thyme and bay leaf. Simmer for 30-40 minutes.",
        "Try a no-knead or focaccia bread. Mix flour, yeast, salt, and water, then let the dough rise for several hours. Shape, add toppings (like rosemary and sea salt for focaccia), and bake until golden brown.",
        "Practice sautéing with a vegetable stir-fry. Heat oil in a pan until shimmering, add thinly sliced vegetables like bell peppers, zucchini, and mushrooms, and stir constantly for even cooking. Season with soy sauce and a pinch of sugar for a flavorful finish.",
        "Build a balanced salad with greens, proteins, and toppings. Try spinach, grilled chicken, sliced almonds, cranberries, and a simple vinaigrette made with olive oil, balsamic vinegar, Dijon mustard, and honey.",
        "Make a basic cookie dough like chocolate chip or oatmeal raisin. Focus on techniques for chewy versus crispy textures by adjusting baking times and adding ingredients like brown sugar for chewiness.",
        "Create a homemade spice blend, such as taco seasoning (chili powder, cumin, paprika, garlic powder) or curry powder (turmeric, cumin, coriander). Use the blend in a dish like tacos or a curry to understand how spices build flavors.",
        "Make a comforting dish like mac and cheese. Start by making a béchamel sauce (butter, flour, milk), then add shredded cheese to create a creamy cheese sauce. Mix with cooked pasta and bake with breadcrumbs for a crispy topping.",
        "Learn to cook grains like quinoa, rice, or farro. Rinse the grains, then cook them in salted boiling water. For added flavor, cook grains in broth or add herbs. Use them as the base for grain bowls with veggies, protein, and dressing.",
        "Make a classic sauce like béchamel or hollandaise. For béchamel, cook butter and flour, then gradually add milk while whisking to avoid lumps. Season with salt, pepper, and nutmeg, and use it for pasta or vegetable bakes.",
        "Experiment with roasting vegetables like carrots, Brussels sprouts, and sweet potatoes. Toss with olive oil, salt, and pepper, then roast at high heat to caramelize the edges. Finish with balsamic vinegar or fresh herbs for extra flavor.",
        "Make a marinade with olive oil, lemon juice, garlic, and herbs, and use it to marinate chicken or veggies. Marinate for at least 30 minutes to infuse flavors, then cook using your preferred method (grilling, roasting, or sautéing).",
        "Prepare tacos with homemade salsa and guacamole. Sauté ground beef or chicken with spices, chop fresh tomatoes and onions for salsa, and mash avocados with lime juice and salt. Assemble with tortillas and your choice of toppings.",
        "Make pizza from scratch, starting with dough. Roll out the dough, spread with tomato sauce, add cheese and toppings, and bake in a hot oven until the crust is golden and cheese is bubbly.",
        "Make a slow-cooked meal like a beef stew. Brown the meat, add vegetables, broth, and seasonings, then cook on low for several hours until tender. This process enhances flavors and tenderizes the meat.",
        "Try different ways of cooking eggs, like scrambled, poached, and sunny-side up. Focus on technique: low heat for scrambled eggs, gentle simmering for poached, and careful timing for frying.",
        " Cook a seafood dish, such as grilled salmon or shrimp scampi. Season the seafood simply with salt, pepper, and lemon, and cook quickly on high heat to preserve its delicate texture.",
        "Try pickling cucumbers, carrots, or onions. Slice thinly, then immerse in a mix of vinegar, water, sugar, and salt. Refrigerate for a few hours before enjoying as a tangy side or topping.",
        "Make a plant-based meal, such as a vegetable curry or lentil soup. Use hearty ingredients like beans, chickpeas, or tofu for protein, and season generously with spices for flavor.",
        "Plan a multi-course meal: a starter, main, and dessert. Prepare dishes that can be made in advance, like a simple soup, roasted chicken with veggies, and chocolate mousse.",
        "Bake a chocolate dessert, like brownies or molten lava cake. Focus on timing and texture to achieve the perfect gooey center or a fudgy bite.",
        "Make a fluffy omelet. Whisk eggs with salt, pour into a hot, buttered pan, then add fillings like cheese, ham, or herbs before folding gently.",
        "Make dumplings or potstickers. Prepare filling with ground meat, vegetables, and seasoning. Fill and fold dumpling wrappers, then pan-fry and steam to cook.",
        "Try a dish from another cuisine, like a Thai curry or Japanese ramen. Use specific ingredients like curry paste or miso to capture authentic flavors.",
        "Use leftovers from the week to make a new dish. Chop and mix into a frittata, stir-fry, or casserole for a creative, zero-waste meal.",
        "Reflect on your cooking journey, noting any favorite dishes or techniques. Plan a grocery list to restock your favorites and try new dishes!")



    private val itemImages = listOf(
        R.drawable.day1, R.drawable.day2, R.drawable.day3, R.drawable.day4, R.drawable.day5,
        R.drawable.day6, R.drawable.day7, R.drawable.day8, R.drawable.day9, R.drawable.day10,
        R.drawable.day11, R.drawable.day12, R.drawable.day13, R.drawable.day14, R.drawable.day15,
        R.drawable.day16, R.drawable.day17, R.drawable.day18, R.drawable.day19, R.drawable.day20,
        R.drawable.day21, R.drawable.day22, R.drawable.day23, R.drawable.day24, R.drawable.day25,
        R.drawable.day26, R.drawable.day27, R.drawable.day28, R.drawable.day29, R.drawable.day30
    )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val days: TextView = itemView.findViewById(R.id.item_days)
        val image: ImageView = itemView.findViewById(R.id.item_image)
        val textTitle: TextView = itemView.findViewById(R.id.item_title)
        val textDesc: TextView = itemView.findViewById(R.id.item_details)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_model, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        // Use the smallest size among all lists to prevent index out of bounds
        return minOf(
            itemDays.size,
            itemTitles.size,
            itemDetails.size,
            itemImages.size
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {
            // Safe binding with null checks and try-catch
            if (position in itemDays.indices) {
                holder.days.text = itemDays[position]
                holder.textTitle.text = itemTitles.getOrNull(position) ?: ""
                holder.textDesc.text = itemDetails.getOrNull(position) ?: ""

                // Safely set image resource
                holder.image.setImageResource(itemImages.getOrNull(position) ?: android.R.drawable.ic_menu_gallery)
            }

            holder.itemView.setOnClickListener { view ->
                try {
                    val title = itemTitles.getOrNull(position) ?: "Item"
                    Toast.makeText(view.context, "Clicked on $title", Toast.LENGTH_SHORT).show()
                } catch (e: Exception) {
                    Toast.makeText(view.context, "Clicked on item", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            // Handle binding error gracefully
            holder.days.text = "Day"
            holder.textTitle.text = "Title"
            holder.textDesc.text = "Description"
            holder.image.setImageResource(android.R.drawable.ic_menu_gallery)
        }
    }
}