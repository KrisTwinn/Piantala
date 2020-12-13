from django.contrib import admin
from piantala.models import Farmer, Genre, Product, ProductInstance
admin.site.register(Genre)

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

from django.contrib.auth.admin import UserAdmin
from .models import User
from .forms import UserCreationForm,UserChangeForm
class UserAdmin(UserAdmin):
    add_form = UserCreationForm
    form = UserChangeForm
    model = User
    list_display = ['email', 'username','first_name','last_name','cellulare','indirizzo','data_di_nascita','is_staff','is_superuser']
admin.site.register(User, UserAdmin)