from django.urls import path
from . import views
from django.urls import include
from piantala.views import register
from django.conf import settings

urlpatterns = [
    path('', views.index, name='index'),
    path('farmers/', views.FarmerListView.as_view(), name='farmers'),
    path('farmer/<int:pk>', views.FarmerDetailView.as_view(), name='farmer-detail'),
    path('products/', views.ProductListView.as_view(), name='products'),
    path('product/<int:pk>', views.ProductDetailView.as_view(), name='product-detail'),
    path('accounts/', include('django.contrib.auth.urls')),
    path('accounts/edit/', views.edit_profile, name= 'edit_profile'),
    path('dashboard/', views.user_dashboard, name='dashboard'),
    
    #path('whoami/', whoami, name="whoami"),
    path('accounts/register/', register, name="register"),
    
]