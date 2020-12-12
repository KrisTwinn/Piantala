from django.views import generic
from django.shortcuts import redirect, render
from django.urls import reverse
from piantala.forms import CustomUserCreationForm,EditProfileForm
from django.contrib.auth.decorators import login_required
# Create your views here.
from piantala.models import Product, Farmer, ProductInstance, Genre

def index(request):
    """View function for home page of site."""

    # Generate counts of some of the main objects
    #num_products = Product.objects.all().count()
    #num_instances = ProductInstance.objects.all().count()
    # Available books (status = 'a')
    #num_instances_available = ProductInstance.objects.filter(status__exact='d').count()
    # The 'all()' is implied by default.    
    #num_farmers = Farmer.objects.count()
    #num_visits = request.session.get('num_visits', 0)
    #request.session['num_visits'] = num_visits + 1
    
    #context = {
    #    'num_products': num_products,
    #    'num_instances': num_instances,
    #    'num_instances_available': num_instances_available,
    #    'num_farmers': num_farmers,
    #    'num_visits': num_visits,
    #}

    # Render the HTML template index.html with the data in the context variable
    #return render(request, 'index.html', context=context)
    return render(request, 'index.html')

def register(request):
    if request.method == "GET":
        return render(
            request, "registration/register.html",
            {"form": CustomUserCreationForm}
        )
    elif request.method == "POST":
        form = CustomUserCreationForm(request.POST)
        if form.is_valid():
            user = form.save()
            login(request, user)
            return redirect(reverse("login"))

@login_required()
def edit_profile(request):
    if request.method == 'POST':
        form = EditProfileForm(request.POST, instance=request.user)

        if form.is_valid():
            form.save()
            return redirect(reverse('dashboard'))
    else:
        form = EditProfileForm(instance=request.user)
        args = {'form': form}
        return render(request, 'registration/edit_profile.html', args)

@login_required()
def user_dashboard(request):
    
    return render(request, "user/dashboard.html")

#@login_required()
#def whoami(request):
#    return render(request, "registration/whoami.html")

class ProductListView(generic.ListView):
    model = Product
    #paginate_by = 3
    #context_object_name = 'my_book_list'   # your own name for the list as a template variable
    #queryset = Book.objects.filter(title__icontains='war')[:5] # Get 5 books containing the title war
    #template_name = 'products/my_arbitrary_template_name_list.html'  # Specify your own template name/location

class ProductDetailView(generic.DetailView):
    model = Product

#View sugli agricoltori
class FarmerListView(generic.ListView):
    model = Farmer

class FarmerDetailView(generic.DetailView):
    model = Farmer