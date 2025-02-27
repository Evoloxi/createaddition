package com.mrh0.createaddition.recipe.rolling;

import com.mrh0.createaddition.CreateAddition;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class RollingRecipe implements Recipe<RecipeWrapper> {

	protected final ItemStack output;
	protected final ResourceLocation id;
	protected final Ingredient ingredient;
	
	public static RecipeType<RollingRecipe> TYPE = new RollingRecipeType();
	@SuppressWarnings("deprecation")
	public static RecipeSerializer<?> SERIALIZER = Registry.RECIPE_SERIALIZER.get(new ResourceLocation(CreateAddition.MODID, "rolling"));

	protected RollingRecipe(Ingredient ingredient, ItemStack output, ResourceLocation id) {
		this.output = output;
		this.id = id;
		this.ingredient = ingredient;
	}
	
	public Ingredient getIngredient() {
		return ingredient;
	}
	
	@Override
	public boolean matches(RecipeWrapper inv, Level worldIn) {
		if (inv.isEmpty())
			return false;
		return ingredient.test(inv.getItem(0));
	}

	@Override
	public ItemStack assemble(RecipeWrapper inv) {
		return this.output;
	}

	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return width * height > 0;
	}

	@Override
	public ItemStack getResultItem() {
		return this.output;
	}

	@Override
	public ResourceLocation getId() {
		return this.id;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		
		return SERIALIZER;
	}

	@Override
	public RecipeType<?> getType() {
		return TYPE;
	}
	
	@Override
	public ItemStack getToastSymbol() {
		return this.output;
	}
	
	@Override
	public boolean isSpecial() {
		return true;
	}
	
	public static void register() {};
}
