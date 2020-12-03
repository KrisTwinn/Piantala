from django.db import models
from django.urls import reverse # Used to generate URLs by reversing the URL patterns
import uuid # Required for unique prod instances

# Genere di un prodotto (esempio: tubero)
class Genre(models.Model):
    name = models.CharField(max_length=25, help_text='Insert genre!')
    
    def __str__(self):
        return self.name

# Modello Prodotto
class Product(models.Model):
    name = models.CharField(max_length=50)

    # Foreign Key used because product can only have one author, but authors can have multiple product
    # Farmer as a string rather than object because it hasn't been declared yet in the file
    farmer = models.ForeignKey('Farmer', on_delete=models.SET_NULL, null=True)
    
    summary = models.TextField(max_length=1000, help_text='Enter a brief description of the product')
    
    # ManyToManyField used because genre can contain many books. Books can cover many genres.
    # Genre class has already been defined so we can specify the object above.
    genre = models.ManyToManyField(Genre, help_text='Select a genre for this product')
    
    def __str__(self):
        """String for representing the Model object."""
        return self.name
    
    def get_absolute_url(self):
        """Returns the url to access a detail record for this product."""
        return reverse('product-detail', args=[str(self.id)])
    
    def display_genre(self):
        return ', '.join(genre.name for genre in self.genre.all()[:3])
    
    display_genre.short_description = 'Genre'

class ProductInstance(models.Model):
    """Model representing a specific copy of a product (i.e. that can be borrowed from the TUMULO)."""
    id = models.UUIDField(primary_key=True, default=uuid.uuid4, help_text='Unique ID for this particular product across istances')
    product = models.ForeignKey('Product', on_delete=models.SET_NULL, null=True) 
    #Data in cui il prodotto potrebbe tornare disponibile
    #due_back = models.DateField(null=True, blank=True)

    LOAN_STATUS = (
        ('d', 'Disponibile'),
        ('p', 'Prenotabile'),
        ('r', 'Riservato'),
        ('e', 'Esaurito'),
        
    )

    status = models.CharField(
        max_length=1,
        choices=LOAN_STATUS,
        blank=True,
        default='d',
        help_text='Product availability',
    )

    #class Meta:
    #    ordering = ['due_back']

    def __str__(self):
        """String for representing the Model object."""
        return f'{self.id} ({self.product.name})'

class Farmer(models.Model):
    """Model representing an farmer."""
    first_name = models.CharField(max_length=100)
    last_name = models.CharField(max_length=100)
    date_of_birth = models.DateField(null=True, blank=True)
    farm_loc = models.CharField(max_length=100)
    phone = models.CharField(max_length=15)

    class Meta:
        ordering = ['last_name', 'first_name']
    
    def get_absolute_url(self):
        """Returns the url to access a particular author instance."""
        return reverse('author-detail', args=[str(self.last_name)])

    def __str__(self):
        """String for representing the Model object."""
        return f'{self.last_name}, {self.first_name}'