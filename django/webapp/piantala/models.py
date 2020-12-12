from django.db import models
from django.urls import reverse # Used to generate URLs by reversing the URL patterns
import uuid # Required for unique prod instances

# Genere di un prodotto (esempio: tubero)
class Genre(models.Model):
    name = models.CharField(max_length=25, help_text='Inserisci genere prodotto!')
    
    def __str__(self):
        return self.name

# Modello Prodotto
class Product(models.Model):
    name = models.CharField(max_length=50)
    farmer = models.ForeignKey('Farmer', on_delete=models.SET_NULL, null=True)
    summary = models.TextField(max_length=1000, help_text='Enter a brief description of the product')
    genre = models.ManyToManyField(Genre, help_text='Select a genre for this product')
    image = models.ImageField(upload_to="gallery")
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
    id = models.UUIDField(primary_key=True, default=uuid.uuid4, help_text='Unique ID for this particular product across istances')
    product = models.ForeignKey('Product', on_delete=models.SET_NULL, null=True) 

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
    image = models.ImageField(upload_to="avatar" , default="")

    class Meta:
        ordering = ['last_name', 'first_name']
    
    def get_absolute_url(self):
        """Returns the url to access a particular author instance."""
        return reverse('farmer-detail', args=[str(self.id)])

    def __str__(self):
        """String for representing the Model object."""
        return f'{self.last_name}, {self.first_name}'


#PROFILI estensione profilo utente
from django.contrib.auth.models import User

class UserProfile(models.Model):
    user = models.OneToOneField(User,on_delete=models.SET_NULL,null=True)
    image = models.ImageField(upload_to="avatar" , default="")
    indirizzo = models.CharField(max_length=50, default='')
    città = models.CharField(max_length=50, default='')
    CAP = models.IntegerField(default='')
    telefono = models.IntegerField(default='')
