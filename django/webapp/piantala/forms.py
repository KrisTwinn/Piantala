from django.contrib.auth.forms import UserCreationForm, UserChangeForm
#from django.contrib.auth.models import User
from piantala.models import User
from django import forms

class UserCreationForm(UserCreationForm):
    email = forms.EmailField()
    nome = forms.CharField(max_length=50)
    cognome = forms.CharField(max_length=50)
    class Meta:
        model = User
        fields = (  'username',
                    'nome',
                    'cognome',
                    'data_di_nascita',
                    'indirizzo',
                    'cellulare',
                    'email',
                    'password1',
                    'password2',
                      )
        help_texts = {
            'username': None,
        }

class UserChangeForm(UserChangeForm):
    template_name='/accounts/edit_profile'
    password = None
    class Meta:
        model = User
        fields = (
            'username',
            'email',
            'first_name',
            'last_name',
            'indirizzo',
            #'password',
                     )
        help_texts = {
            'username': None,
        }