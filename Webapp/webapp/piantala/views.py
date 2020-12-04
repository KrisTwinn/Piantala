from django.shortcuts import render
from django.views import generic

# Create your views here.

from piantala.models import Product, Farmer, ProductInstance, Genre

def index(request):
    """View function for home page of site."""

    # Generate counts of some of the main objects
    num_products = Product.objects.all().count()
    num_instances = ProductInstance.objects.all().count()
    # Available books (status = 'a')
    num_instances_available = ProductInstance.objects.filter(status__exact='d').count()
    # The 'all()' is implied by default.    
    num_farmers = Farmer.objects.count()
    num_visits = request.session.get('num_visits', 0)
    request.session['num_visits'] = num_visits + 1
    
    context = {
        'num_products': num_products,
        'num_instances': num_instances,
        'num_instances_available': num_instances_available,
        'num_farmers': num_farmers,
        'num_visits': num_visits,
    }

    # Render the HTML template index.html with the data in the context variable
    return render(request, 'index.html', context=context)

#La view sulla lista dei prodotti

class ProductListView(generic.ListView):
    model = Product
    #context_object_name = 'my_book_list'   # your own name for the list as a template variable
    #queryset = Book.objects.filter(title__icontains='war')[:5] # Get 5 books containing the title war
    #template_name = 'products/my_arbitrary_template_name_list.html'  # Specify your own template name/location

class ProductDetailView(generic.DetailView):
    model = Product