from django.contrib import admin

# Register your models here.

from piantala.models import Farmer, Genre, Product, ProductInstance,UserProfile

#admin.site.register(Product)
#admin.site.register(Farmer)
admin.site.register(Genre)
#admin.site.register(ProductInstance)
admin.site.register(UserProfile)

# Define the admin class
class FarmerAdmin(admin.ModelAdmin):
     list_display = ('last_name', 'first_name', 'farm_loc')

# Register the admin class with the associated model
admin.site.register(Farmer, FarmerAdmin)

# Register the Admin classes for Product using the decorator
@admin.register(Product)
class ProductAdmin(admin.ModelAdmin):
    list_display = ('name', 'farmer', 'display_genre')

# Register the Admin classes for BookInstance using the decorator
@admin.register(ProductInstance) 
class ProductInstanceAdmin(admin.ModelAdmin):
    list_display = ('product', 'status', 'id')
    list_filter = ('status', 'product')