from django.contrib.auth.forms import UserCreationForm, UserChangeForm
#from django.contrib.auth.models import User
from piantala.models import ProfileUser
from django import forms

class UserCreationForm(UserCreationForm):
    template_name='/dashboard/'
    class Meta:
        model = ProfileUser
        fields = (  'username',
                    'first_name',
                    'last_name',
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

class AdminCreationForm(UserCreationForm):
    template_name='/dashboard/'
    class Meta:
        model = ProfileUser
        fields = (  'username',
                    'first_name',
                    'last_name',
                    'data_di_nascita',
                    'indirizzo',
                    'cellulare',
                    'email',
                    'is_staff',
                    'groups',
                    'user_permissions'
                      )
        help_texts = {
            'username': None,
        }

class UserChangeForm(UserChangeForm):
    template_name='/accounts/edit_profile'
    data_di_nascita = forms.DateField()
    password = None
    class Meta:
        model = ProfileUser
        fields = (
            'username',
            'first_name',
            'last_name',
            'indirizzo',
            'cellulare',
            'email',
            'data_di_nascita',
            'image'
            #'password',
                     )
        help_texts = {
            'username': None,
        }

#class AvatarEditForm(UserChangeForm):
#    class Meta:
#        model = ProfileUser
#        fields = ('image','data_di_nascita')